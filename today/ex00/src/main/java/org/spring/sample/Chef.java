package org.spring.sample;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component // 스프링이 직접 해당 클래스를 관리해야 하는 대상임을 표시
@Data // Lombok의 setter, getter, toString(), 기본 생성자등 자동 생성 
public class Chef {

}
