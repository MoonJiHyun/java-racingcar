package racingcargame.domain.vehicle;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racingcargame.domain.common.Distance;
import racingcargame.domain.common.Name;
import racingcargame.domain.vehicle.factory.AlwaysForwardCarFactory;
import racingcargame.domain.vehicle.factory.CarFactory;
import racingcargame.domain.vehicle.factory.NormalCarFactory;

@DisplayName("자동차")
class CarTest {

    private final CarFactory normalCarFactory = new NormalCarFactory();
    private final CarFactory alwaysForwardEngine = new AlwaysForwardCarFactory();

    public static Stream<Arguments> normalCarInfo() {
        return Stream.of(Arguments.of(
            new Name("pobi"), new Distance(0))
        );
    }

    @DisplayName("[성공] 생성")
    @ParameterizedTest
    @MethodSource("normalCarInfo")
    public void create(Name name, Distance distance) {
        // given

        // when
        Car car = normalCarFactory.create(name, distance);

        // then
        assertThat(car.getName()).isEqualTo(name);
        assertThat(car.getDistance()).isEqualTo(distance);
    }

    @DisplayName("[성공] 주행")
    @ParameterizedTest
    @MethodSource("normalCarInfo")
    public void drive(Name name, Distance distance) {
        // given
        Car car = alwaysForwardEngine.create(name, distance);

        // when
        car.drive();

        // then
        Distance expected = new Distance(1);
        assertThat(car.getDistance()).isEqualTo(expected);
    }
}
