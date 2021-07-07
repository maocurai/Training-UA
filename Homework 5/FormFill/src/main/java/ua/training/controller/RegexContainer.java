package ua.training.controller;

public interface RegexContainer {

    String REGEX_PATRONYMIC_UA = "^[А-ЩЬЮЯҐІЇЄ][а-щьюяґіїє']{1,20}$";
    String REGEX_SURNAME_LAT = "[A-Z]([a-z]+([-][A-Z]([a-z])+)?)";
    String REGEX_SURNAME_UA = "[А-ЩЬЮЯҐІЇЄ]([а-щьюяґіїє']+([-][А-ЩЬЮЯҐІЇЄ]([а-щьюяґіїє'])+)?)";
    String REGEX_NICKNAME = "^[a-zA-Z0-9_.]{1,30}$";
    String REGEX_PATRONYMIC_LAT = "^[A-Z][a-z]+$";
    String REGEX_MOBILE_PHONE = "^\\+\\d{2}\\(\\d{3}\\)\\d{3}-\\d{2}-\\d{2}$";
    String REGEX_EMAIL = "^([a-z0-9_-]+\\.)*[a-z0-9_-]+@[a-z0-9_-]+(\\.[a-z0-9_-]+)*\\.[a-z]{2,6}$";

}
