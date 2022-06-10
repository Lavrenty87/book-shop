package ru.learnup.bookshop.view;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.learnup.bookshop.security.Rolez;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RolezView {
    private String rolez;

    public RolezView(Rolez rolez) {
        this.rolez = rolez.getRolez();
    }
}
