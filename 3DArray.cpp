#include <iostream>

#define DIMENSION_1_LENGTH 10
#define DIMENSION_2_LENGTH 10
#define DIMENSION_3_LENGTH 10

int main(int argc, char** argv)
{
	int myArray[DIMENSION_1_LENGTH][DIMENSION_2_LENGTH][DIMENSION_3_LENGTH];
	
	for(size_t x = 0; x < DIMENSION_1_LENGTH; x++)
		for(size_t y = 0; y < DIMENSION_2_LENGTH; y++)
			for(size_t z = 0; z < DIMENSION_3_LENGTH; z++)
				myArray[x][y][z] = x * y - z;

	for(size_t x = 0; x < DIMENSION_1_LENGTH; x++)
		for(size_t y = 0; y < DIMENSION_2_LENGTH; y++)
			for(size_t z = 0; z < DIMENSION_3_LENGTH; z++)
				std::cout << '(' << x << ',' << y << ',' << z << ") : " << myArray[x][y][z] << '\n';

	return 0;
}