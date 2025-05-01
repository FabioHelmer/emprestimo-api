package com.fh.emprestimo.controllers.dto;

import java.util.List;

public record ClienteEmprestimoResponse(String cliente, List<EmprestimoResponse> emprestimos) {
}
