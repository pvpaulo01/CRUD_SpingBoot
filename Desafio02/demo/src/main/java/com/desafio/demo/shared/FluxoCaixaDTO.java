package com.desafio.demo.shared;

public class FluxoCaixaDTO {
    private Double totalPagar;

    private Double totalReceber;

    
    public FluxoCaixaDTO(Double totalPagar, Double totalReceber) {
        this.totalPagar = totalPagar;
        this.totalReceber = totalReceber;
    }

    public Double getTotalPagar() {
        return totalPagar;
    }

    public void setTotalPagar(Double totalPagar) {
        this.totalPagar = totalPagar;
    }

    public Double getTotalReceber() {
        return totalReceber;
    }

    public void setTotalReceber(Double totalReceber) {
        this.totalReceber = totalReceber;
    }

    
    
}
