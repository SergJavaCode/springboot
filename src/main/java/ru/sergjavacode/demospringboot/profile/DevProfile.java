package ru.sergjavacode.demospringboot.profile;

import ru.sergjavacode.demospringboot.SystemProfile;

public class DevProfile implements SystemProfile {
    @Override
    public String getProfile() {
        return "Current profile is dev";
    }
}