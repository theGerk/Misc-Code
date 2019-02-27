/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * File:   main.cpp
 * Author: Benji
 *
 * Created on October 12, 2017, 3:56 PM
 */

#include <cstdlib>
#include <unistd.h>

using namespace std;

/*
 *
 */
int main(int argc, char** argv) {
	if (fork()) {
		cout << "Hello from parent process" << std::endl;
	} else {
		cout << "Hello from child process" << std::endl;
	}
}

