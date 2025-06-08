package org.example.Entities.User;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.example.Entities.Base;
import org.example.Entities.Geography.Domicilio;
import org.example.Entities.Imagen;
import org.example.Entities.Orders.Pedido;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity
@Table(name = "clientes")
public class Cliente extends Base {
    @Column(nullable = false)
    private String nombre;
    @Column(nullable = false)
    private String apellido;
    @Column(nullable = false)
    private String correo;
    @Column(nullable = false)
    private String telefono;
    @Temporal(TemporalType.DATE)
    private LocalDate fechaNacimiento;

    //Pedidios
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinTable(name = "pedido_id",
            joinColumns = @JoinColumn(name = "cliente_id"),
            inverseJoinColumns = @JoinColumn(name = "pedido_id"))
    @Builder.Default
    private Set<Pedido> pedidos = new HashSet<>();

    //Domicilio
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "cliente_id",
            joinColumns = @JoinColumn(name = "cliente_id"),
            inverseJoinColumns = @JoinColumn(name = "domicilio_id"))
    @Builder.Default
    private Set<Domicilio> domicilios = new HashSet<>();


    //Usuario
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    //Imagen
    @ManyToOne(cascade = CascadeType.ALL)
    private Imagen imagen;

    public void addDomicilio(Domicilio d) {
        this.domicilios.add(d);
    }

    public void addPedido(Pedido p) {
        this.pedidos.add(p);
    }

    public void addImagen(Imagen i) {
        this.imagen = i;
    }

    public void removePedido(Pedido p) {
        this.pedidos.remove(p);
    }

    public void removeImagen(Imagen i) {
        this.imagen = null;
    }

    public void removeDomicilio(Domicilio d) {
        this.domicilios.remove(d);
    }
}
