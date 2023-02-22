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
@Table(name = "title")
public class Title {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "titleId", nullable = false)
    private Integer titleId;
    
    @Column(name = "titleName", nullable = false, length = 45)
    private String titleName;
    
    @Column(name = "titleDesc", nullable = true, length = -1)
    private String titleDesc;

    @OneToMany(mappedBy = "title")
    private List<EmployeeTitleHistory> employeeTitleHistoryList;
}
