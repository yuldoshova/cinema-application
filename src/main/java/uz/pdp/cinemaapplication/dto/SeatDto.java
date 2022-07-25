package uz.pdp.cinemaapplication.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.PackagePrivate;


@AllArgsConstructor
@NoArgsConstructor
@Data
@PackagePrivate
public class SeatDto {
    Integer number;

    String categoryName;

    Integer addFeeInPercent;
}
