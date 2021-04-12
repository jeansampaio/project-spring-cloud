package com.wysoft.user.VO;

import com.wysoft.user.entity.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseTempleteVO {
    private User user;
    private Department department;
}
