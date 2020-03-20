public class DogLoop{
    public static void main(String[] ags){
        Dog smallDog = new Dog(5);
        Dog mediumDog = new Dog(25);
        Dog hugeDog = new Dog(150);

        /**Dog[], [] initialize an array, new Dog[4] means the Dog.length == 4*/
        Dog[] manyDogs = new Dog[4];
        manyDogs[0] = smallDog;
        manyDogs[1] = hugeDog;
        manyDogs[2] = new Dog(130);
        manyDogs[3] = new Dog(20);

        int i = 0;
        while (i < manyDogs.length){
            Dog newDog = Dog.maxDog(manyDogs[i], mediumDog);
            newDog.makeNoise();
            i = i + 1;
        }
    }
}