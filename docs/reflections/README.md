# 고민, 생각

### 도메인 객체 생성 방법

도메인 객체는 핵심 비즈니스 로직을 구현하는 데 중요한 역할을 하며, 다른 계층의 영향으로부터 독립적이어야 합니다. 이를 위해 private 생성자를 사용하여 클래스 외부에서의 직접적인 인스턴스 생성을 방지하고, 객체 생성 과정을 제어합니다. 이는 유효하지 않은 상태의 객체 생성을 막는 데 도움이 됩니다.

```java
@Getter
@AllArgsConstructor(access = lombok.AccessLevel.PRIVATE)
public class Membership {
   private final MembershipId membershipId;
   private final MembershipName name;
   // ...

   public static Membership generateMembership(MembershipId membershipId, MembershipName membershipName, MembershipEmail membershipEmail, MembershipAddress membershipAddress, MembershipIsValid membershipIsValid, MembershipIsCorp membershipIsCorp) {
      return new Membership(membershipId, membershipName, membershipEmail, membershipAddress, membershipIsValid, membershipIsCorp);
   }
   // ...
}
```

### 도메인 특화 타입 방법, 위치

도메인 특화 타입을 사용할 때 내부 클래스로 구성해서 불변 객체로 만들어서 사용

> 도메인 특화 타입 장점  
> 
> 1. 데이터 항목에 대해 고유한 타입을 정의함으로써, 잘못된 타입의 데이터가 해당 필드에 할당되는 것을 방지   
> e.g. String 타입을 대신 MembershipEmail이라는 명시적 타입을 사용함으로써, 이메일 주소와 관련된 필드에 오직 유효한 이메일 데이터만 할당되도록 할 수 있다.
> 2. 각 필드가 어떤 데이터를 나타내는지 명확하게 표현되고 도메인 모델을 이해하고 사용하는데 도움이 됩니다.
> 3. 추가적인 유효성 검사 및 로직 포함할 수 있습니다.

```java
public class Membership {
    // ...

    @Value
    public static class MembershipId {
        String membershipId;

        public MembershipId(String value) {
            this.membershipId = value;
        }
    }
    // ... 
}
```

JDK 16부터는 record를 사용하면 더 간결하게 사용할 수 있다.

```java
public class Membership {
    // ...

    public record MembershipId(String membershipId) {}
    // ... 
}
```
내부 클래스로 구현하는 것은 도메인 객체를 묶어 관리할 수 있다는 장점이 있지만, 외부 클래스와 생명주기가 다르게 된다. 

그리고 record는 항상 정적이므로, 클래스가 메모리에 로드될 때 생성되고, 언로드될 때까지 메모리에 남아 있어 불필요한 메모리 사용을 초래할 수 있다.

-> 클래스로 따로 분리해서 사용하는 것이 좋을 것 같다.