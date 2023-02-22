package com.publisher.modules.employeeAndAccount.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "role")
public class Role {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "roleId", nullable = false)
    private Integer roleId;
    
    @Column(name = "roleName", nullable = false, length = 45)
    private String roleName;
    
    @Column(name = "roleDesc", nullable = true, length = -1)
    private String roleDesc;

    @OneToMany(mappedBy = "role")
    private List<Account> accountList;

    @OneToMany(mappedBy = "role")
    private List<RoleRightList> roleRightList;
}
