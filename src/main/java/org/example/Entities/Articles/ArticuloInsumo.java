package org.example.Entities.Articles;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "articuloinsumo")
@SuperBuilder
public class ArticuloInsumo extends Articulo {
    private double precioCompra;
    private int stockActual;
    private int stockMaximo;
    private boolean esParaElaborar;
}