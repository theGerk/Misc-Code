.data
__newline__: .byte '\n'

.text
main:
	li $v0, 11
	li $a0, 'h'
	syscall
	li $a0, 'i'
	syscall
	lb $a0, __newline__
	syscall
	li $a0, 'h'
	syscall
	li $a0, 'i'
	syscall
	li $v0, 10
	syscall