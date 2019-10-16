// 实现一种狗猫队列的结构，要求如下：
// 用户可以调用add方法将cat类或dog类的实例放入队列中；
// 用户可以调用pollAll方法，将队列中所有的实例按照进队列的先后顺序依次弹出；
// 用户可以调用pollDog方法，将队列中dog类的实例按照进队列的先后顺序依次弹出；
// 用户可以调用pollCat方法，将队列中cat类的实例按照进队列的先后顺序依次弹出；

import java.util.LinkedList;
import java.util.Queue;

public class C3_DogCatQueue {

    public static class Pet{
        private String type;

        public Pet(String type){
            this.type = type;
        }

        public String getPetType(){
            return this.type;
        }
    }

    public static class Dog extends Pet{
        public Dog() {
            super("dog");
        }
    }

    public static class Cat extends Pet{
        public Cat() {
            super("dog");
        }
    }

    public static class PetEnterQueue{
        private Pet pet;
        private long index;

        public PetEnterQueue(Pet pet, long count){
            this.pet = pet;
            this.index = count;
        }

        public Pet getPet(){
            return this.pet;
        }

        public long getCount(){
            return this.index;
        }

        public String getEnterPetType(){
            return this.pet.getPetType();
        }
    }

    public static class DogCatQueue{
        private Queue<PetEnterQueue> dogQ;
        private Queue<PetEnterQueue> catQ;
        private long index;

        public DogCatQueue(){
            this.dogQ = new LinkedList<PetEnterQueue>();
            this.catQ = new LinkedList<PetEnterQueue>();
            this.index = 0;
        }

        public void add(Pet pet){
            if(pet.getPetType().equals("dog")){
                this.dogQ.add(new PetEnterQueue(pet,this.index++));
            }else if(pet.getPetType().equals("cat")){
                this.catQ.add(new PetEnterQueue(pet,this.index++));
            }else {
                throw new RuntimeException("err, not dog or cat");
            }
        }

        public Dog pollDog(){
            if(!this.dogQ.isEmpty()){
                return (Dog) this.dogQ.poll().getPet();
            }else {
                throw new RuntimeException("Dog queue is empty");
            }
        }

        public Cat pollCat(){
            if(!this.catQ.isEmpty()){
                return (Cat) this.catQ.poll().getPet();
            }else {
                throw new RuntimeException("Cat queue is empty");
            }
        }

        public Pet pollAll(){
            if(!this.dogQ.isEmpty() && !this.catQ.isEmpty()){
                if(this.dogQ.peek().getCount() < this.catQ.peek().getCount()){
                    return this.dogQ.poll().getPet();
                }else {
                    return this.catQ.poll().getPet();
                }
            }else if(!this.dogQ.isEmpty()){
                return this.dogQ.poll().getPet();
            }else if(!this.catQ.isEmpty()){
                return this.catQ.poll().getPet();
            }else {
                throw new RuntimeException("err,queue is empty");
            }
        }
    }
}
