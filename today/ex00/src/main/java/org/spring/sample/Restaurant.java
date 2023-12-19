package org.spring.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*
 * 의존성 주입 방법  
 * Setter 주입 @Setter(onMethod_ = {@Autowired})
 * 생성자 주입 @AllArgsConstructor
 * 필드 주입 @Autowired
 * 최근 가장 핫한 방법 final사용 @RequiredArgsConstructor
 */

@Component
@ToString
@RequiredArgsConstructor
public class Restaurant {
	
	private final Chef chef; 
	
	
}
