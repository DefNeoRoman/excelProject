package stepik.unit10;

import java.io.*;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        Animal[] animals = {
                new Animal("слон"),
                new Animal("жираф"),
                new Animal("макака"),
                new Animal("лошадь")

        };
        ByteArrayOutputStream bos = new ByteArrayOutputStream();

        try (ObjectOutput out = new ObjectOutputStream(bos)) {
            out.writeInt(animals.length);
            for (Animal a : animals) {
                out.writeObject(a);
            }
            out.flush();
            byte[] data = bos.toByteArray();
            Animal[] animals1 = deserializeAnimalArray(data);
            System.out.println(Arrays.toString(animals1));
        }

    }

    public static Animal[] deserializeAnimalArray(byte[] data) {
        Animal[] animals = new Animal[0];
        try(ByteArrayInputStream bis = new ByteArrayInputStream(data)) {
            try(ObjectInput in = new ObjectInputStream(bis)) {
               int c = 0;
               animals = new Animal[in.readInt()];
                while(bis.available() != 0){
                    Animal ani = (Animal)in.readObject();
                    animals[c] = ani;
                    c++;
                }

            } catch (IOException e) {
                e.printStackTrace();
            } catch ( ClassNotFoundException e){
                throw new IllegalArgumentException();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return animals;

    }
}
