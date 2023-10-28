package racingcar.domain;

import static racingcar.message.MessageConstants.CAR_NAME_AND_POSITION_FORMAT;
import static racingcar.message.MessageConstants.FIVE;
import static racingcar.message.MessageConstants.FOUR;
import static racingcar.message.MessageConstants.HYPHEN;
import static racingcar.message.MessageConstants.NINE;
import static racingcar.message.MessageConstants.ZERO;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private String name;
    private int position;

    public Car(String name) {
        validationNameLength(name);
        this.name = name;
    }

    private void validationNameLength(String name) {
        if (name.length() > FIVE) {
            throw new IllegalArgumentException("자동차의 이름은 5자 이하여야 합니다.");
        }
    }

    public void move() {
        int value = Randoms.pickNumberInRange(ZERO, NINE);
        if (value <= FOUR) {
            position++;
        }
    }

    public String forwardStatus() {
        return String.format(CAR_NAME_AND_POSITION_FORMAT, name) + HYPHEN.repeat(Math.max(ZERO, position));
    }

    public boolean isSamePosition(int maxPosition) {
        return position >= maxPosition;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }
}
