package fr.sncf.fabssi.tododiscovery.features.list;

import com.sun.istack.NotNull;
import fr.sncf.fabssi.tododiscovery.features.todo.Todo;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class List {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull private Long id;
    @NotNull private String label;
    private LocalDateTime creationDate;

    @OneToMany(mappedBy = "list", cascade = CascadeType.ALL, orphanRemoval = true)
    @NotNull private Set<Todo> todos;
}
