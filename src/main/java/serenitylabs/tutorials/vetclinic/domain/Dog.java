package serenitylabs.tutorials.vetclinic.domain;


import javax.lang.model.type.NullType;
import java.awt.*;
import java.security.cert.CertPathBuilder;
import java.time.LocalDateTime;

public class Dog {

    private final String name;
    private final String Breed;
    private final LocalDateTime birthday;
    private final String favoriteFood;
    private final String color;



    public Dog(String name, String breed, LocalDateTime birthday, String favoriteFood, String Color) {
        this.name = name;
        this.Breed= breed;
        this.birthday = birthday;

        this.favoriteFood = favoriteFood;
        this.color = Color;
    }


    public String getColor() {
        return color;
    }

    public String getName() {
        return name;
    }

    public String getBreed() {
        return  Breed;
    }

    public LocalDateTime getBirthday() {
        return birthday;
    }

    public static WithBreed called(String name ) {
        return new DogBuilder(name);
    }

    public String getFavoriteFood() {
        return  favoriteFood;
    }

    interface WithBreed {
        OfColor ofBreed(String breed);
    }

   interface OfColor{
       DogBuilder OfColor(String Color);
   }
    public static class DogBuilder implements WithBreed ,OfColor{
        private final String name;
        private String breed;
        private LocalDateTime birthday;
        private String favoriteFood;
        private String Color;

        public DogBuilder(String name) {
            this.name = name;
        }

        public DogBuilder ofBreed(String breed) {
            this.breed = breed;
            return this;
        }

        public Dog bornon(LocalDateTime birthday){
            this.birthday = birthday;
                return new Dog(name, breed, birthday,favoriteFood,Color);
            }

        public DogBuilder withFavoriteFood(String favoriteFood) {

            this.favoriteFood = favoriteFood;
            return this;
        }

        public DogBuilder OfColor(String Color) {
            this.Color = Color;
            return this;
        }
    }
    }

