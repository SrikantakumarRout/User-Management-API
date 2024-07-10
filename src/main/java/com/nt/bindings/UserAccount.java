package com.nt.bindings;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserAccount {
	private Integer userId; //will not filled up during the registration
	private String name;
	private String email;
	private Long mobileNo;
	private String gender="Female";
	private LocalDate dob=LocalDate.now();
	private Long aadharNo;

}
