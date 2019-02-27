#include <iostream>
#include <cstdlib>

#include <GL/glew.h>

#include <glfw3.h>

#include<glm/glm.hpp>
using namespace glm;

int main()
{
	if (!glfwInit())
	{
		std::cerr << "Failed to initialize GLFW\n";
		return -1;
	}

	// sets 4x antialiasing
	glfwWindowHint(GLFW_SAMPLES, 4);

	//sets version 3.3
	glfwWindowHint(GLFW_CONTEXT_VERSION_MAJOR, 3);
	glfwWindowHint(GLFW_CONTEXT_VERSION_MINOR, 3);

	//we don't want the old OpenGL
	glfwWindowHint(GLFW_OPENGL_PROFILE, GLFW_OPENGL_CORE_PROFILE);

	//create window
	GLFWwindow* window = glfwCreateWindow(1024, 768, "Get fucked", NULL, NULL);

	if (window == NULL)
	{
		std::cerr << "Failed to open GLFW window. If you have an Intel GPU, they are not 3.3 compatible. Try the 2.1 version of the tutorials.\n";
		glfwTerminate();
		return -1;
	}


	//init glew
	glfwMakeContextCurrent(window);

	//needed in core profile
	glewExperimental = true;
	
	if (glewInit() != GLEW_OK)
	{
		std::cerr << "Failed to initialize GLEW\n";
		return -1;
	}

	//make sure we can capture the excape key being pressed
	glfwSetInputMode(window, GLFW_STICKY_KEYS, GL_TRUE);

	//set up VAO, whatever that is (Vertex Array Object)
	GLuint VertexArrayID;
	glGenVertexArrays(1, &VertexArrayID);
	glBindVertexArray(VertexArrayID);


	//an aray of 3 vectors in R^3
	static const GLfloat g_vertex_buffer_data[] {
		-1.0f, -1.0f, 0.0f,
		1.0f, -1.0f, 0.0f,
		0.0f, 1.0f, 0.0f
	};

	//this will identify our vertex buffer
	GLuint vertexbuffer;

	//generate a buffer, put the resulting identifier in vertexbuffer
	glGenBuffers(1, &vertexbuffer);

	//the following commands will talk about vertexbuffer
	glBindBuffer(GL_ARRAY_BUFFER, vertexbuffer);
	//give our verticies to opengl
	glBufferData(GL_ARRAY_BUFFER, sizeof(g_vertex_buffer_data), g_vertex_buffer_data, GL_STATIC_DRAW);
	

	do {
		//1st attribute buffer : verticies
		glEnableVertexAttribArray(0);
		glBindBuffer(GL_ARRAY_BUFFER, vertexbuffer);
		glVertexAttribPointer(0, 3, GL_FLOAT, GL_FALSE, 0, (void*)0);

		//get drawed
		glDrawArrays(GL_TRIANGLES, 0, 3);

		glDisableVertexAttribArray(0);

		//swap bufers
		glfwSwapBuffers(window);
		glfwPollEvents();

	} while (glfwGetKey(window, GLFW_KEY_ESCAPE) != GLFW_PRESS && glfwWindowShouldClose(window) == 0);
}
