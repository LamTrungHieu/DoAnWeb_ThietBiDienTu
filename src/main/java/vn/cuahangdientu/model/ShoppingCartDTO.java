package vn.cuahangdientu.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ShoppingCartDTO {
    private Integer productId;
    private String productName;
    private Double productPrice;
    private Integer shoppingCartQuantity;
    private String productImage;
}
