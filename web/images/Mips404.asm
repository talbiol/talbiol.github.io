
.data
buffer_for_input_string: .space 100
buffer_for_processed_string: .space 100
prompt_for_input: .asciiz "Please enter your string:\n"
prompt_for_output: .asciiz "Your processed string is as follows:\n"

.text
main:
li $v0, 4
la $a0, prompt_for_input
syscall
li $v0, 8
la $a0, buffer_for_input_string
li $a1, 100
syscall

la      $t0, buffer_for_input_string
la      $t1, buffer_for_processed_string

LOOP:
lb      $t2, 0($t0) 
beq     $t2, 32, space
yes:
sb      $t2, 0($t1)
addi    $t1, $t1, 1
no:
addi    $t3, $zero, 1
addi    $t0, $t0, 1
bne     $t2, $zero, LOOP
beq     $t2, $zero, exit

space:
sb      $t2, 0($t1)
addi    $t1, $t1, 1
addi    $t0, $t0, 1
lb      $t2, 0($t0) 
bne     $t2, 97, yes   # a
bne     $t2, 98, yes   # b
bne     $t2, 99, yes   # c
bne     $t2, 100, yes   # d
bne     $t2, 101, yes   # e
bne     $t2, 102, yes   # f
bne     $t2, 103, yes   # g
bne     $t2, 104, yes   # h
bne     $t2, 105, yes   # i
bne     $t2, 106, yes   # j
bne     $t2, 107, yes   # k
bne     $t2, 108, yes   # l
bne     $t2, 109, yes   # m
bne     $t2, 110, yes   # n
bne     $t2, 111, yes   # o
bne     $t2, 112, yes   # p
bne     $t2, 113, yes   # q
bne     $t2, 114, yes   # r
bne     $t2, 115, yes   # s
bne     $t2, 116, yes   # t
bne     $t2, 117, yes   # u
bne     $t2, 118, yes   # v
bne     $t2, 119, yes   # w
bne     $t2, 120, yes   # x
bne     $t2, 121, yes   # y
bne     $t2, 122, yes   # z
beq     $t2, $zero, exit



exit:
li $v0, 4
la $a0, prompt_for_output
syscall
la $a0, buffer_for_processed_string
syscall
li $v0, 10      # syscall code for exit
syscall         # exit


# Remove any word that does not start with a capital letter. For instance, for the input text of "Hello, 2022 world!", 
# we should get "Hello, 2022 !".