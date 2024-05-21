package com.mi.usermanagement.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mi.usermanagement.anno.NotEmptyString;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    @NotBlank(message = "用户名不能为空")
    @Size(min = 3, max = 10, message = "用户名长度必须在3到10个字符之间")
    @Column(nullable = false, unique = true)
    private String userName;

    @JsonIgnore
    @NotBlank(message = "密码不能为空")
    @Size(min = 6, max = 20, message = "密码长度必须在6到20个字符之间")
    @Column(nullable = false)
    private String password;

    @NotNull(message = "部门ID不能为空")
    private Integer deptId;
    @NotNull(message = "职位ID不能为空")
    private Integer postId;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createTime;

    @Column(nullable = false)
    private LocalDateTime updateTime;

    @Enumerated(EnumType.STRING)
    private ApprovalStatus approvalStatus= ApprovalStatus.NO_PENDING_APPROVAL;
}
