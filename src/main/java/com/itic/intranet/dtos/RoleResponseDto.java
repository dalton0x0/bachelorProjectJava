package com.itic.intranet.dtos;

import com.itic.intranet.enums.RoleType;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RoleResponseDto {
    private Long id;
    private RoleType roleType;
    private String wording;
}