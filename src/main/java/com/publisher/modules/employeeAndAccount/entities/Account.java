package com.publisher.modules.employeeAndAccount.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "account")
public class Account {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "accountId", nullable = false)
    private Integer accountId;

    @ManyToOne
    @JoinColumn(name = "roleId", referencedColumnName = "roleId")
    private Role role;
    @Column(name = "roleId", nullable = false, insertable = false, updatable = false)
    private Integer roleId;
    
    @Column(name = "employeeId", nullable = false)
    private Integer employeeId;
    
    @Column(name = "username", nullable = false, length = 45)
    private String username;
    
    @Column(name = "password", nullable = false, length = 45)
    private String password;
}
