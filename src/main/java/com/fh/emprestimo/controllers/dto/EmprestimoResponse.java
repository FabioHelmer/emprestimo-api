package com.fh.emprestimo.controllers.dto;

import com.fh.emprestimo.domain.EmprestimoType;

public record EmprestimoResponse(EmprestimoType tipo, double grauInteresse) {
}
