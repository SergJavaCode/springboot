package ru.sergjavacode.demospringboot.profile;

import ru.sergjavacode.demospringboot.SystemProfile;

public class ProductionProfile implements SystemProfile {
    @Override
    public String getProfile() {
        return "Current profile is production";
    }
}
