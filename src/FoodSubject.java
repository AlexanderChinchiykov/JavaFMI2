public interface FoodSubject {
        void attach(Trainee trainee, FoodMenu foodMenu);
        void detach(Trainee trainee);
        void notifyObservers();
}
