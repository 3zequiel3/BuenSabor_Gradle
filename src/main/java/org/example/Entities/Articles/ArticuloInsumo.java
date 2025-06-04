package org.example.Entities.Articles;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "articuloinsumo")

public class ArticuloInsumo extends Articulo {
    private double precioCompra;
    private int stockActual;
    private int stockMaximo;
    private boolean esParaElaborar;
}
