package com.fh.emprestimo.service;

import com.fh.emprestimo.controllers.dto.ClienteEmprestimoRequest;
import com.fh.emprestimo.controllers.dto.ClienteEmprestimoResponse;
import com.fh.emprestimo.controllers.dto.EmprestimoResponse;
import com.fh.emprestimo.domain.Emprestimo;
import com.fh.emprestimo.domain.EmprestimoType;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmprestimoService {

    public ClienteEmprestimoResponse checkDisponibilidadeEmprestimo(ClienteEmprestimoRequest request){
        var cliente  = request.toCliente();
        var emprestimo = new Emprestimo(cliente);

        List<EmprestimoResponse> emprestimos = new ArrayList<>();

        if(emprestimo.isEmprestimoPessoalDisponivel()){
            emprestimos.add(new EmprestimoResponse(EmprestimoType.PESSOAL, emprestimo.getTaxaJurosEmprestimoPessoal()));
        }

        if(emprestimo.isEmprestimoConsignadoDisponivel()){
            emprestimos.add(new EmprestimoResponse(EmprestimoType.CONSIGNADO, emprestimo.getTaxaJurosEmprestimoConsignado()));
        }

        if(emprestimo.isEmprestimoGarantiaDisponivel()){
            emprestimos.add(new EmprestimoResponse(EmprestimoType.GARANTIA, emprestimo.getTaxaJurosEmprestimoGarantia()));
        }

        return new ClienteEmprestimoResponse(request.nome(), emprestimos);
    }
}

