package fr.sncf.fabssi.tododiscovery.features.todo;

import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Builder
public class TodoServiceInput {
    @NotNull private String label;
    @NotNull private boolean done;
    private LocalDate dueDate;
    @NotNull private Long listId;
}
