package com.ApexParty.searchparty.config.auth.dto;

import com.ApexParty.searchparty.domain.users.Role;
import com.ApexParty.searchparty.domain.users.Users;
import lombok.Builder;
import lombok.Getter;

import java.util.Map;

@Getter
public class OAuthAttributes {
    private Map<String, Object> attributes;
    private String nameAttributeKey;
    private String name;
    private String email;
    private String picture;

    @Builder
    public OAuthAttributes(Map<String, Object> attributes,String nameAttributeKey, String name,String email, String picture) {
        this.attributes = attributes;
        this.nameAttributeKey = nameAttributeKey;
        this.email = email;
        this.name = name;
        this.picture = picture;
    }

    public static OAuthAttributes of(String registrationId, String userNameAttributeName,Map<String, Object> attributes) {
        return ofGoogle(userNameAttributeName, attributes);
    }

    public static OAuthAttributes ofGoogle(String userNameAttributeName, Map<String, Object> attributes) {
        return OAuthAttributes.builder()
                .name((String) attributes.get("name"))
                .email((String) attributes.get("email"))
                .picture((String) attributes.get("picture"))
                .attributes(attributes)
                .nameAttributeKey(userNameAttributeName)
                .build();
    }

    public Users toEntity() {
        return Users.builder()
                .name(name)
                .email(email)
                .picture(picture)
                .role(Role.GUEST)
                .build();
    }
}

// 세션에 저장하기 위해 Users 클래스를 사용한다면 직렬화를 구현해야 함 -> Users 는 엔티티이기에 다른 엔티티와 관계형성이 가능 -> 직렬화대상에 포함되면 성능이슈, 부수 효과가 발생함 -> 직렬화 기능을 가진 세션 Dto를 하나 추가로 만든다.
