package pojos.Promocode;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
public class PPromoCode {
    private  int id,number_of_users,discount;
    private  String code,starts_at,ends_at,discount_type;

    public PPromoCode(int id,String code,String starts_at,String ends_at, int number_of_users, int discount,String discount_type) {
        this.id = id;
        this.number_of_users = number_of_users;
        this.discount = discount;
        this.code = code;
        this.starts_at = starts_at;
        this.ends_at = ends_at;
        this.discount_type = discount_type;
    }
}
