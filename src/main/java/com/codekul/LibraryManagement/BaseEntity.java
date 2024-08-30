package com.codekul.LibraryManagement;

import com.codekul.LibraryManagement.user.entity.Users;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
@MappedSuperclass
public class BaseEntity {

    @ManyToOne
    @JoinColumn(name = "created_by")
    private Users createdBy;

    @ManyToOne
    @JoinColumn(name = "last_modified_by")
    private Users lastModifiedBy;

    private LocalDate createdDate = LocalDate.now();

    private LocalDate lastModifiedDate = LocalDate.now();
}
