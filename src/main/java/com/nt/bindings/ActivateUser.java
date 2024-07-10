package com.nt.bindings;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ActivateUser {
private String email;
private String tempPassword;
private String newPassword;
private String confirmPassword;
}
