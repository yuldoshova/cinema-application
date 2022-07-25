package uz.pdp.cinemaapplication.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.PackagePrivate;

@NoArgsConstructor
@AllArgsConstructor
@Data
@PackagePrivate
public class Result {

    String message;
    boolean isSuccess;
    Object data;


    public Result(String message, boolean isSuccess) {
        this.message = message;
        this.isSuccess = isSuccess;
    }
}
