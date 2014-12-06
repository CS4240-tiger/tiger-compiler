.data
t0: .word 0
t1: .word 0
t2: .word 0
t3: .word 0
t4: .float 0.0
t5: .word 0
t6: .word 0
t8: .word 5
t9: .word 5
t10: .word 0
t7: .word 0
t11: .word 0
t12: .word 0
t13: .word 0
t14: .word 0
t16: .float 5.0
t17: .float 5.0
t18: .word 0
t15: .word 0
t20: .word 5
t21: .float 5.0
t22: .word 0
t19: .word 0
t24: .float 5.0
t25: .word 5
t26: .word 0
t23: .word 0
t28: .word 5
t29: .word 5
t30: .word 0
t27: .word 0
t31: .word 0
t32: .word 0
t33: .word 0
t34: .word 0
t35: .word 1
t36: .word 2
t37: .word 0
t38: .word 0
t39: .word 1
t40: .word 9000
t41: .word 9000
t42: .word 1
t43: .word 1
t44: .word 0
.text
func1: 
la $at, t0
lw $t0, 0($at)
la $at, t0
sw $t0, 0($at)
la $at, t0
lw $t0, 0($at)
addi $sp, $sp, 1
lw $fp, 0($sp)
addi $sp, $sp, 1
lw $ra, 0($sp)
add $sp, $fp, $zero
jr $ra
la $at, t0
sw $t0, 0($at)
la $at, t1
lw $t0, 0($at)
la $at, t1
sw $t0, 0($at)
la $at, t1
lw $t0, 0($at)
addi $sp, $sp, 1
lw $fp, 0($sp)
addi $sp, $sp, 1
lw $ra, 0($sp)
add $sp, $fp, $zero
jr $ra
la $at, t1
sw $t0, 0($at)
func2: 
la $at, t2
lw $t0, 0($at)
la $at, t2
sw $t0, 0($at)
la $at, t2
lw $t0, 0($at)
addi $sp, $sp, 1
lw $fp, 0($sp)
addi $sp, $sp, 1
lw $ra, 0($sp)
add $sp, $fp, $zero
jr $ra
la $at, t2
sw $t0, 0($at)
func3: 
la $at, t3
lw $t0, 0($at)
la $at, t3
sw $t0, 0($at)
la $at, t3
lw $t0, 0($at)
addi $sp, $sp, 1
lw $fp, 0($sp)
addi $sp, $sp, 1
lw $ra, 0($sp)
add $sp, $fp, $zero
jr $ra
la $at, t3
sw $t0, 0($at)
func4: 
la $at, t4
lw $f0, 0($at)
la $at, t4
sw $f0, 0($at)
la $at, t4
lw $f0, 0($at)
addi $sp, $sp, 1
lw $fp, 0($sp)
addi $sp, $sp, 1
lw $ra, 0($sp)
add $sp, $fp, $zero
jr $ra
la $at, t4
sw $f0, 0($at)
main: 
la $at, t5
lw $t0, 0($at)
add $at, $fp, $zero
add $fp, $sp, $zero
addi $sp, $sp, -1
sw p, 0($sp)
addi $sp, $sp, -1
sw $ra, 0($sp)
addi $sp, $sp, -1
sw $at, 0($sp)
jr $t0
sw $v0, func1($zero)
add $t0, $v0, $zero
la $at, t5
sw $t0, 0($at)
la $at, t6
lw $t0, 0($at)
add $at, $fp, $zero
add $fp, $sp, $zero
addi $sp, $sp, -1
sw int_var, 0($sp)
addi $sp, $sp, -1
sw $ra, 0($sp)
addi $sp, $sp, -1
sw $at, 0($sp)
jr $t0
sw $v0, func1($zero)
add $t0, $v0, $zero
la $at, t6
sw $t0, 0($at)
la $at, t8
lw $t0, 0($at)
la $at, t8
sw $t0, 0($at)
la $at, t9
lw $t0, 0($at)
la $at, t9
sw $t0, 0($at)
la $at, t8
lw $t0, 0($at)
la $at, t9
lw $t1, 0($at)
la $at, t10
lw $t2, 0($at)
add $t2, $t0, $t1
la $at, t10
sw $t2, 0($at)
la $at, t9
sw $t1, 0($at)
la $at, t8
sw $t0, 0($at)
la $at, t7
lw $t0, 0($at)
la $at, t10
lw $t1, 0($at)
add $at, $fp, $zero
add $fp, $sp, $zero
addi $sp, $sp, -1
sw $t1, 0($sp)
addi $sp, $sp, -1
sw $ra, 0($sp)
addi $sp, $sp, -1
sw $at, 0($sp)
jr $t0
sw $v0, func1($zero)
add $t0, $v0, $zero
la $at, t10
sw $t1, 0($at)
la $at, t7
sw $t0, 0($at)
la $at, t11
lw $t0, 0($at)
add $at, $fp, $zero
add $fp, $sp, $zero
addi $sp, $sp, -1
sw 5.0, 0($sp)
addi $sp, $sp, -1
sw $ra, 0($sp)
addi $sp, $sp, -1
sw $at, 0($sp)
jr $t0
sw $v0, func2($zero)
add $t0, $v0, $zero
la $at, t11
sw $t0, 0($at)
la $at, t12
lw $t0, 0($at)
add $at, $fp, $zero
add $fp, $sp, $zero
addi $sp, $sp, -1
sw 5, 0($sp)
addi $sp, $sp, -1
sw $ra, 0($sp)
addi $sp, $sp, -1
sw $at, 0($sp)
jr $t0
sw $v0, func2($zero)
add $t0, $v0, $zero
la $at, t12
sw $t0, 0($at)
la $at, t13
lw $t0, 0($at)
add $at, $fp, $zero
add $fp, $sp, $zero
addi $sp, $sp, -1
sw fixedpt_var, 0($sp)
addi $sp, $sp, -1
sw $ra, 0($sp)
addi $sp, $sp, -1
sw $at, 0($sp)
jr $t0
sw $v0, func2($zero)
add $t0, $v0, $zero
la $at, t13
sw $t0, 0($at)
la $at, t14
lw $t0, 0($at)
add $at, $fp, $zero
add $fp, $sp, $zero
addi $sp, $sp, -1
sw int_var, 0($sp)
addi $sp, $sp, -1
sw $ra, 0($sp)
addi $sp, $sp, -1
sw $at, 0($sp)
jr $t0
sw $v0, func2($zero)
add $t0, $v0, $zero
la $at, t14
sw $t0, 0($at)
la $at, t16
lw $f0, 0($at)
la $at, t16
sw $f0, 0($at)
la $at, t17
lw $f0, 0($at)
la $at, t17
sw $f0, 0($at)
la $at, t16
lw $f0, 0($at)
la $at, t17
lw $f1, 0($at)
la $at, t18
lw $t0, 0($at)
add $t0, $f0, $f1
la $at, t18
sw $t0, 0($at)
la $at, t17
sw $f1, 0($at)
la $at, t16
sw $f0, 0($at)
la $at, t15
lw $t0, 0($at)
la $at, t18
lw $t1, 0($at)
add $at, $fp, $zero
add $fp, $sp, $zero
addi $sp, $sp, -1
sw $t1, 0($sp)
addi $sp, $sp, -1
sw $ra, 0($sp)
addi $sp, $sp, -1
sw $at, 0($sp)
jr $t0
sw $v0, func2($zero)
add $t0, $v0, $zero
la $at, t18
sw $t1, 0($at)
la $at, t15
sw $t0, 0($at)
la $at, t20
lw $t0, 0($at)
la $at, t20
sw $t0, 0($at)
la $at, t21
lw $f0, 0($at)
la $at, t21
sw $f0, 0($at)
la $at, t20
lw $t0, 0($at)
la $at, t21
lw $f0, 0($at)
la $at, t22
lw $t1, 0($at)
add $t1, $t0, $f0
la $at, t22
sw $t1, 0($at)
la $at, t21
sw $f0, 0($at)
la $at, t20
sw $t0, 0($at)
la $at, t19
lw $t0, 0($at)
la $at, t22
lw $t1, 0($at)
add $at, $fp, $zero
add $fp, $sp, $zero
addi $sp, $sp, -1
sw $t1, 0($sp)
addi $sp, $sp, -1
sw $ra, 0($sp)
addi $sp, $sp, -1
sw $at, 0($sp)
jr $t0
sw $v0, func2($zero)
add $t0, $v0, $zero
la $at, t22
sw $t1, 0($at)
la $at, t19
sw $t0, 0($at)
la $at, t24
lw $f0, 0($at)
la $at, t24
sw $f0, 0($at)
la $at, t25
lw $t0, 0($at)
la $at, t25
sw $t0, 0($at)
la $at, t24
lw $f0, 0($at)
la $at, t25
lw $t0, 0($at)
la $at, t26
lw $t1, 0($at)
add $t1, $f0, $t0
la $at, t26
sw $t1, 0($at)
la $at, t25
sw $t0, 0($at)
la $at, t24
sw $f0, 0($at)
la $at, t23
lw $t0, 0($at)
la $at, t26
lw $t1, 0($at)
add $at, $fp, $zero
add $fp, $sp, $zero
addi $sp, $sp, -1
sw $t1, 0($sp)
addi $sp, $sp, -1
sw $ra, 0($sp)
addi $sp, $sp, -1
sw $at, 0($sp)
jr $t0
sw $v0, func2($zero)
add $t0, $v0, $zero
la $at, t26
sw $t1, 0($at)
la $at, t23
sw $t0, 0($at)
la $at, t28
lw $t0, 0($at)
la $at, t28
sw $t0, 0($at)
la $at, t29
lw $t0, 0($at)
la $at, t29
sw $t0, 0($at)
la $at, t28
lw $t0, 0($at)
la $at, t29
lw $t1, 0($at)
la $at, t30
lw $t2, 0($at)
add $t2, $t0, $t1
la $at, t30
sw $t2, 0($at)
la $at, t29
sw $t1, 0($at)
la $at, t28
sw $t0, 0($at)
la $at, t27
lw $t0, 0($at)
la $at, t30
lw $t1, 0($at)
add $at, $fp, $zero
add $fp, $sp, $zero
addi $sp, $sp, -1
sw $t1, 0($sp)
addi $sp, $sp, -1
sw $ra, 0($sp)
addi $sp, $sp, -1
sw $at, 0($sp)
jr $t0
sw $v0, func2($zero)
add $t0, $v0, $zero
la $at, t30
sw $t1, 0($at)
la $at, t27
sw $t0, 0($at)
la $at, t31
lw $t0, 0($at)
add $at, $fp, $zero
add $fp, $sp, $zero
addi $sp, $sp, -1
sw int_type_var, 0($sp)
addi $sp, $sp, -1
sw $ra, 0($sp)
addi $sp, $sp, -1
sw $at, 0($sp)
jr $t0
sw $v0, func3($zero)
add $t0, $v0, $zero
la $at, t31
sw $t0, 0($at)
la $at, t32
lw $t0, 0($at)
add $at, $fp, $zero
add $fp, $sp, $zero
addi $sp, $sp, -1
sw int_type_var2, 0($sp)
addi $sp, $sp, -1
sw $ra, 0($sp)
addi $sp, $sp, -1
sw $at, 0($sp)
jr $t0
sw $v0, func3($zero)
add $t0, $v0, $zero
la $at, t32
sw $t0, 0($at)
la $at, t33
lw $t0, 0($at)
add $at, $fp, $zero
add $fp, $sp, $zero
addi $sp, $sp, -1
sw fixedpt_type_var, 0($sp)
addi $sp, $sp, -1
sw $ra, 0($sp)
addi $sp, $sp, -1
sw $at, 0($sp)
jr $t0
sw $v0, func4($zero)
add $t0, $v0, $zero
la $at, t33
sw $t0, 0($at)
la $at, t34
lw $t0, 0($at)
add $at, $fp, $zero
add $fp, $sp, $zero
addi $sp, $sp, -1
sw fixedpt_type_var2, 0($sp)
addi $sp, $sp, -1
sw $ra, 0($sp)
addi $sp, $sp, -1
sw $at, 0($sp)
jr $t0
sw $v0, func4($zero)
add $t0, $v0, $zero
la $at, t34
sw $t0, 0($at)
88422-loop: 
la $at, t35
lw $t0, 0($at)
la $at, t35
sw $t0, 0($at)
la $at, t36
lw $t0, 0($at)
la $at, t36
sw $t0, 0($at)
la $at, t35
lw $t0, 0($at)
la $at, t36
lw $t1, 0($at)
bne $t0, $t1, 88422-expr-eval
la $at, t36
sw $t1, 0($at)
la $at, t35
sw $t0, 0($at)
la $at, t37
lw $t0, 0($at)
add $at, $fp, $zero
add $fp, $sp, $zero
addi $sp, $sp, -1
sw int_type_var, 0($sp)
addi $sp, $sp, -1
sw $ra, 0($sp)
addi $sp, $sp, -1
sw $at, 0($sp)
jr $t0
sw $v0, func3($zero)
add $t0, $v0, $zero
la $at, t37
sw $t0, 0($at)
la $at, t38
lw $t0, 0($at)
add $at, $fp, $zero
add $fp, $sp, $zero
addi $sp, $sp, -1
sw fixedpt_type_var, 0($sp)
addi $sp, $sp, -1
sw $ra, 0($sp)
addi $sp, $sp, -1
sw $at, 0($sp)
jr $t0
sw $v0, func4($zero)
add $t0, $v0, $zero
la $at, t38
sw $t0, 0($at)
jr 88422-expr-eval
jr 88422-loop
88422-expr-eval: 
la $at, t39
lw $t0, 0($at)
la $at, t39
sw $t0, 0($at)
la $at, t40
lw $t0, 0($at)
la $at, t40
sw $t0, 0($at)
84365-loop: 
la $at, t39
lw $t0, 0($at)
la $at, t40
lw $t1, 0($at)
bne $t0, $t1, 84365-expr-eval
la $at, t40
sw $t1, 0($at)
la $at, t39
sw $t0, 0($at)
la $at, t41
lw $t0, 0($at)
la $at, t41
sw $t0, 0($at)
la $at, t41
lw $t0, 0($at)
la $at, t41
sw $t0, 0($at)
jr 84365-expr-eval
la $at, t42
lw $t0, 0($at)
la $at, t39
lw $t1, 0($at)
la $at, t39
sw $t1, 0($at)
la $at, t42
sw $t0, 0($at)
la $at, t43
lw $t0, 0($at)
la $at, t43
sw $t0, 0($at)
la $at, t42
lw $t0, 0($at)
la $at, t43
lw $t1, 0($at)
la $at, t44
lw $t2, 0($at)
add $t2, $t0, $t1
la $at, t44
sw $t2, 0($at)
la $at, t43
sw $t1, 0($at)
la $at, t42
sw $t0, 0($at)
la $at, t39
lw $t0, 0($at)
la $at, t44
lw $t1, 0($at)
la $at, t44
sw $t1, 0($at)
la $at, t39
sw $t0, 0($at)
jr 84365-loop
84365-expr-eval: 
