package com.example.demo.schedulers;


import com.example.demo.services.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Random;


@Configuration
@EnableScheduling
@Component
public class DogAddingScheduler {


    private DogService dogService;

    @Autowired
    public DogAddingScheduler(DogService dogService) {
        this.dogService = dogService;
    }

    @Scheduled(cron = "*/30 * * * * *")
    @Scheduled(cron = "59 59 23 28 2 *")
    @Scheduled(cron = "59 59 23 30 4,5,9,11 *")
    @Scheduled(cron = "59 59 23 31 1,3,5,7,8,10,12 *")
    public void addRandomDog() {

        String randomDogName = randomGeneratedString();
        Random random = new Random();

        int randomAge = random.nextInt(10);

        boolean randomSterilized = random.nextBoolean();

        String randomGender = random.nextBoolean() ? "female" : "male";

        dogService.createDog(randomDogName, randomAge, randomGender, randomSterilized, 6);

    }

    public String randomGeneratedString() {
        int leftLimit = 97;
        int rightLimit = 122;
        int targetStringLength = 5;
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(targetStringLength);
        for (int i = 0; i < targetStringLength; i++) {
            int randomLimitedInt = leftLimit + (int)
                    (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }
        return buffer.toString();
    }
}


