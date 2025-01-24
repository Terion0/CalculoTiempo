import random
import time

def generate_random_number():
    delay = random.randint(2, 8)  # Tiempo aleatorio entre 2 y 8 segundos
    time.sleep(delay)  # Pausa por el tiempo aleatorio
    return random.randint(3, 12)  # Número aleatorio entre 3 y 12

if __name__ == "__main__":
    print(generate_random_number())