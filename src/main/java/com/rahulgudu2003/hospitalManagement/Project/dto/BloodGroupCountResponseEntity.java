package com.rahulgudu2003.hospitalManagement.Project.dto;

import com.rahulgudu2003.hospitalManagement.Project.entity.type.BloodGroupType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
public class BloodGroupCountResponseEntity {
    private BloodGroupType bloodGroupType;
    private Long count;
}
