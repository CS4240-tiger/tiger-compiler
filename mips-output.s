.data
t1: .word 0
t0: .word 0
t3: .word 0
t2: .word 0
t5: .word 0
t4: .word 0
t7: .word 0
t6: .word 0
t9: .float 0.0
t8: .float 0.0
t57: .word 5
t50: .word 5
t502: .word 5
t51: .word 5
t10: .word 0
t11: .word 0
t13: .word 5
t14: .word 5
t15: .word 0
t12: .word 0
t16: .word 0
t17: .word 0
t18: .word 0
t19: .word 0
t21: .float 5.0
t22: .float 5.0
t23: .word 0
t20: .word 0
t25: .word 5
t26: .float 5.0
t27: .word 0
t24: .word 0
t29: .float 5.0
t30: .word 5
t31: .word 0
t28: .word 0
t33: .word 5
t34: .word 5
t35: .word 0
t32: .word 0
t36: .word 0
t37: .word 0
t38: .word 0
t39: .word 0
t40: .word 1
t41: .word 2
t42: .word 0
t43: .word 0
t44: .word 1
t45: .word 9000
t46: .word 9000
t47: .word 1
t48: .word 1
t49: .word 0
.text
func1:
la $v1, t1
lw $t0, 0($v1)
la $v1, t1
sw $t0, 0($v1)
la $v1, t0
lw $t0, 0($v1)
la $v1, t1
lw $t1, 0($v1)
la $v1, t1
sw $t1, 0($v1)
la $v1, t0
sw $t0, 0($v1)
la $v1, t0
lw $t0, 0($v1)
addi $sp, $sp, 1
lw $fp, 0($sp)
addi $sp, $sp, 1
lw $ra, 0($sp)
add $sp, $fp, $zero
jr $ra
la $v1, t0
sw $t0, 0($v1)
la $v1, t3
lw $t0, 0($v1)
la $v1, t3
sw $t0, 0($v1)
la $v1, t2
lw $t0, 0($v1)
la $v1, t3
lw $t1, 0($v1)
la $v1, t3
sw $t1, 0($v1)
la $v1, t2
sw $t0, 0($v1)
la $v1, t2
lw $t0, 0($v1)
addi $sp, $sp, 1
lw $fp, 0($sp)
addi $sp, $sp, 1
lw $ra, 0($sp)
add $sp, $fp, $zero
jr $ra
la $v1, t2
sw $t0, 0($v1)
func2:
la $v1, t5
lw $t0, 0($v1)
la $v1, t5
sw $t0, 0($v1)
la $v1, t4
lw $t0, 0($v1)
la $v1, t5
lw $t1, 0($v1)
la $v1, t5
sw $t1, 0($v1)
la $v1, t4
sw $t0, 0($v1)
la $v1, t4
lw $t0, 0($v1)
addi $sp, $sp, 1
lw $fp, 0($sp)
addi $sp, $sp, 1
lw $ra, 0($sp)
add $sp, $fp, $zero
jr $ra
la $v1, t4
sw $t0, 0($v1)
func3:
la $v1, t7
lw $t0, 0($v1)
la $v1, t7
sw $t0, 0($v1)
la $v1, t6
lw $t0, 0($v1)
la $v1, t7
lw $t1, 0($v1)
la $v1, t7
sw $t1, 0($v1)
la $v1, t6
sw $t0, 0($v1)
la $v1, t6
lw $t0, 0($v1)
addi $sp, $sp, 1
lw $fp, 0($sp)
addi $sp, $sp, 1
lw $ra, 0($sp)
add $sp, $fp, $zero
jr $ra
la $v1, t6
sw $t0, 0($v1)
func4:
la $v1, t9
l.s $f0, 0($v1)
la $v1, t9
s.s $f0, 0($v1)
la $v1, t8
l.s $f0, 0($v1)
la $v1, t9
l.s $f1, 0($v1)
la $v1, t9
s.s $f1, 0($v1)
la $v1, t8
s.s $f0, 0($v1)
la $v1, t8
l.s $f0, 0($v1)
addi $sp, $sp, 1
lw $fp, 0($sp)
addi $sp, $sp, 1
lw $ra, 0($sp)
add $sp, $fp, $zero
jr $ra
la $v1, t8
s.s $f0, 0($v1)
main:
la $v1, t57
lw $t0, 0($v1)
la $v1, t57
sw $t0, 0($v1)
la $v1, t50
lw $t0, 0($v1)
la $v1, t50
sw $t0, 0($v1)
la $v1, t502
lw $t0, 0($v1)
la $v1, t502
sw $t0, 0($v1)
la $v1, t51
lw $t0, 0($v1)
la $v1, t51
sw $t0, 0($v1)
la $v1, t10
lw $t0, 0($v1)
la $v1, t51
lw $t1, 0($v1)
add $v1, $fp, $zero
add $fp, $sp, $zero
addi $sp, $sp, -1
sw $t1, 0($sp)
addi $sp, $sp, -1
sw $ra, 0($sp)
addi $sp, $sp, -1
sw $v1, 0($sp)
jr $t0
sw $v0, func1($zero)
add $t0, $v0, $zero
la $v1, t51
sw $t1, 0($v1)
la $v1, t10
sw $t0, 0($v1)
la $v1, t11
lw $t0, 0($v1)
la $v1, t57
lw $t1, 0($v1)
add $v1, $fp, $zero
add $fp, $sp, $zero
addi $sp, $sp, -1
sw $t1, 0($sp)
addi $sp, $sp, -1
sw $ra, 0($sp)
addi $sp, $sp, -1
sw $v1, 0($sp)
jr $t0
sw $v0, func1($zero)
add $t0, $v0, $zero
la $v1, t57
sw $t1, 0($v1)
la $v1, t11
sw $t0, 0($v1)
la $v1, t13
lw $t0, 0($v1)
la $v1, t13
sw $t0, 0($v1)
la $v1, t14
lw $t0, 0($v1)
la $v1, t57
lw $t1, 0($v1)
la $v1, t57
sw $t1, 0($v1)
la $v1, t14
sw $t0, 0($v1)
la $v1, t13
lw $t0, 0($v1)
la $v1, t14
lw $t1, 0($v1)
la $v1, t15
lw $t2, 0($v1)
add $t2, $t0, $t1
la $v1, t15
sw $t2, 0($v1)
la $v1, t14
sw $t1, 0($v1)
la $v1, t13
sw $t0, 0($v1)
la $v1, t12
lw $t0, 0($v1)
la $v1, t15
lw $t1, 0($v1)
add $v1, $fp, $zero
add $fp, $sp, $zero
addi $sp, $sp, -1
sw $t1, 0($sp)
addi $sp, $sp, -1
sw $ra, 0($sp)
addi $sp, $sp, -1
sw $v1, 0($sp)
jr $t0
sw $v0, func1($zero)
add $t0, $v0, $zero
la $v1, t15
sw $t1, 0($v1)
la $v1, t12
sw $t0, 0($v1)
la $v1, t16
lw $t0, 0($v1)
add $v1, $fp, $zero
add $fp, $sp, $zero
addi $sp, $sp, -1
sw 5.0, 0($sp)
addi $sp, $sp, -1
sw $ra, 0($sp)
addi $sp, $sp, -1
sw $v1, 0($sp)
jr $t0
sw $v0, func2($zero)
add $t0, $v0, $zero
la $v1, t16
sw $t0, 0($v1)
la $v1, t17
lw $t0, 0($v1)
add $v1, $fp, $zero
add $fp, $sp, $zero
addi $sp, $sp, -1
sw 5, 0($sp)
addi $sp, $sp, -1
sw $ra, 0($sp)
addi $sp, $sp, -1
sw $v1, 0($sp)
jr $t0
sw $v0, func2($zero)
add $t0, $v0, $zero
la $v1, t17
sw $t0, 0($v1)
la $v1, t18
lw $t0, 0($v1)
add $v1, $fp, $zero
add $fp, $sp, $zero
addi $sp, $sp, -1
sw fixedt51t_var, 0($sp)
addi $sp, $sp, -1
sw $ra, 0($sp)
addi $sp, $sp, -1
sw $v1, 0($sp)
jr $t0
sw $v0, func2($zero)
add $t0, $v0, $zero
la $v1, t18
sw $t0, 0($v1)
la $v1, t19
lw $t0, 0($v1)
la $v1, t57
lw $t1, 0($v1)
add $v1, $fp, $zero
add $fp, $sp, $zero
addi $sp, $sp, -1
sw $t1, 0($sp)
addi $sp, $sp, -1
sw $ra, 0($sp)
addi $sp, $sp, -1
sw $v1, 0($sp)
jr $t0
sw $v0, func2($zero)
add $t0, $v0, $zero
la $v1, t57
sw $t1, 0($v1)
la $v1, t19
sw $t0, 0($v1)
la $v1, t21
l.s $f0, 0($v1)
la $v1, t21
s.s $f0, 0($v1)
la $v1, t22
l.s $f0, 0($v1)
la $v1, t22
s.s $f0, 0($v1)
la $v1, t21
l.s $f0, 0($v1)
la $v1, t22
l.s $f1, 0($v1)
la $v1, t23
lw $t0, 0($v1)
add $t0, $f0, $f1
la $v1, t23
sw $t0, 0($v1)
la $v1, t22
s.s $f1, 0($v1)
la $v1, t21
s.s $f0, 0($v1)
la $v1, t20
lw $t0, 0($v1)
la $v1, t23
lw $t1, 0($v1)
add $v1, $fp, $zero
add $fp, $sp, $zero
addi $sp, $sp, -1
sw $t1, 0($sp)
addi $sp, $sp, -1
sw $ra, 0($sp)
addi $sp, $sp, -1
sw $v1, 0($sp)
jr $t0
sw $v0, func2($zero)
add $t0, $v0, $zero
la $v1, t23
sw $t1, 0($v1)
la $v1, t20
sw $t0, 0($v1)
la $v1, t25
lw $t0, 0($v1)
la $v1, t25
sw $t0, 0($v1)
la $v1, t26
l.s $f0, 0($v1)
la $v1, t26
s.s $f0, 0($v1)
la $v1, t25
lw $t0, 0($v1)
la $v1, t26
l.s $f0, 0($v1)
la $v1, t27
lw $t1, 0($v1)
add $t1, $t0, $f0
la $v1, t27
sw $t1, 0($v1)
la $v1, t26
s.s $f0, 0($v1)
la $v1, t25
sw $t0, 0($v1)
la $v1, t24
lw $t0, 0($v1)
la $v1, t27
lw $t1, 0($v1)
add $v1, $fp, $zero
add $fp, $sp, $zero
addi $sp, $sp, -1
sw $t1, 0($sp)
addi $sp, $sp, -1
sw $ra, 0($sp)
addi $sp, $sp, -1
sw $v1, 0($sp)
jr $t0
sw $v0, func2($zero)
add $t0, $v0, $zero
la $v1, t27
sw $t1, 0($v1)
la $v1, t24
sw $t0, 0($v1)
la $v1, t29
l.s $f0, 0($v1)
la $v1, t29
s.s $f0, 0($v1)
la $v1, t30
lw $t0, 0($v1)
la $v1, t57
lw $t1, 0($v1)
la $v1, t57
sw $t1, 0($v1)
la $v1, t30
sw $t0, 0($v1)
la $v1, t29
l.s $f0, 0($v1)
la $v1, t30
lw $t0, 0($v1)
la $v1, t31
lw $t1, 0($v1)
add $t1, $f0, $t0
la $v1, t31
sw $t1, 0($v1)
la $v1, t30
sw $t0, 0($v1)
la $v1, t29
s.s $f0, 0($v1)
la $v1, t28
lw $t0, 0($v1)
la $v1, t31
lw $t1, 0($v1)
add $v1, $fp, $zero
add $fp, $sp, $zero
addi $sp, $sp, -1
sw $t1, 0($sp)
addi $sp, $sp, -1
sw $ra, 0($sp)
addi $sp, $sp, -1
sw $v1, 0($sp)
jr $t0
sw $v0, func2($zero)
add $t0, $v0, $zero
la $v1, t31
sw $t1, 0($v1)
la $v1, t28
sw $t0, 0($v1)
la $v1, t33
lw $t0, 0($v1)
la $v1, t33
sw $t0, 0($v1)
la $v1, t34
lw $t0, 0($v1)
la $v1, t57
lw $t1, 0($v1)
la $v1, t57
sw $t1, 0($v1)
la $v1, t34
sw $t0, 0($v1)
la $v1, t33
lw $t0, 0($v1)
la $v1, t34
lw $t1, 0($v1)
la $v1, t35
lw $t2, 0($v1)
add $t2, $t0, $t1
la $v1, t35
sw $t2, 0($v1)
la $v1, t34
sw $t1, 0($v1)
la $v1, t33
sw $t0, 0($v1)
la $v1, t32
lw $t0, 0($v1)
la $v1, t35
lw $t1, 0($v1)
add $v1, $fp, $zero
add $fp, $sp, $zero
addi $sp, $sp, -1
sw $t1, 0($sp)
addi $sp, $sp, -1
sw $ra, 0($sp)
addi $sp, $sp, -1
sw $v1, 0($sp)
jr $t0
sw $v0, func2($zero)
add $t0, $v0, $zero
la $v1, t35
sw $t1, 0($v1)
la $v1, t32
sw $t0, 0($v1)
la $v1, t36
lw $t0, 0($v1)
la $v1, t50
lw $t1, 0($v1)
add $v1, $fp, $zero
add $fp, $sp, $zero
addi $sp, $sp, -1
sw $t1, 0($sp)
addi $sp, $sp, -1
sw $ra, 0($sp)
addi $sp, $sp, -1
sw $v1, 0($sp)
jr $t0
sw $v0, func3($zero)
add $t0, $v0, $zero
la $v1, t50
sw $t1, 0($v1)
la $v1, t36
sw $t0, 0($v1)
la $v1, t37
lw $t0, 0($v1)
la $v1, t502
lw $t1, 0($v1)
add $v1, $fp, $zero
add $fp, $sp, $zero
addi $sp, $sp, -1
sw $t1, 0($sp)
addi $sp, $sp, -1
sw $ra, 0($sp)
addi $sp, $sp, -1
sw $v1, 0($sp)
jr $t0
sw $v0, func3($zero)
add $t0, $v0, $zero
la $v1, t502
sw $t1, 0($v1)
la $v1, t37
sw $t0, 0($v1)
la $v1, t38
lw $t0, 0($v1)
add $v1, $fp, $zero
add $fp, $sp, $zero
addi $sp, $sp, -1
sw fixedt51t_tyt51e_var, 0($sp)
addi $sp, $sp, -1
sw $ra, 0($sp)
addi $sp, $sp, -1
sw $v1, 0($sp)
jr $t0
sw $v0, func4($zero)
add $t0, $v0, $zero
la $v1, t38
sw $t0, 0($v1)
la $v1, t39
lw $t0, 0($v1)
add $v1, $fp, $zero
add $fp, $sp, $zero
addi $sp, $sp, -1
sw fixedt51t_tyt51e_var2, 0($sp)
addi $sp, $sp, -1
sw $ra, 0($sp)
addi $sp, $sp, -1
sw $v1, 0($sp)
jr $t0
sw $v0, func4($zero)
add $t0, $v0, $zero
la $v1, t39
sw $t0, 0($v1)
91472-loot51:
la $v1, t40
lw $t0, 0($v1)
la $v1, t40
sw $t0, 0($v1)
la $v1, t41
lw $t0, 0($v1)
la $v1, t41
sw $t0, 0($v1)
la $v1, t40
lw $t0, 0($v1)
la $v1, t41
lw $t1, 0($v1)
bne $t0, $t1, 91472-ext51r-eval
la $v1, t41
sw $t1, 0($v1)
la $v1, t40
sw $t0, 0($v1)
la $v1, t42
lw $t0, 0($v1)
la $v1, t50
lw $t1, 0($v1)
add $v1, $fp, $zero
add $fp, $sp, $zero
addi $sp, $sp, -1
sw $t1, 0($sp)
addi $sp, $sp, -1
sw $ra, 0($sp)
addi $sp, $sp, -1
sw $v1, 0($sp)
jr $t0
sw $v0, func3($zero)
add $t0, $v0, $zero
la $v1, t50
sw $t1, 0($v1)
la $v1, t42
sw $t0, 0($v1)
la $v1, t43
lw $t0, 0($v1)
add $v1, $fp, $zero
add $fp, $sp, $zero
addi $sp, $sp, -1
sw fixedt51t_tyt51e_var, 0($sp)
addi $sp, $sp, -1
sw $ra, 0($sp)
addi $sp, $sp, -1
sw $v1, 0($sp)
jr $t0
sw $v0, func4($zero)
add $t0, $v0, $zero
la $v1, t43
sw $t0, 0($v1)
jr 91472-ext51r-eval
jr 91472-loot51
91472-ext51r-eval:
la $v1, t44
lw $t0, 0($v1)
la $v1, t44
sw $t0, 0($v1)
la $v1, t45
lw $t0, 0($v1)
la $v1, t45
sw $t0, 0($v1)
20017-loot51:
la $v1, t44
lw $t0, 0($v1)
la $v1, t45
lw $t1, 0($v1)
bne $t0, $t1, 20017-ext51r-eval
la $v1, t45
sw $t1, 0($v1)
la $v1, t44
sw $t0, 0($v1)
la $v1, t46
lw $t0, 0($v1)
la $v1, t46
sw $t0, 0($v1)
la $v1, t50
lw $t0, 0($v1)
la $v1, t46
lw $t1, 0($v1)
la $v1, t46
sw $t1, 0($v1)
la $v1, t50
sw $t0, 0($v1)
jr 20017-ext51r-eval
la $v1, t47
lw $t0, 0($v1)
la $v1, t44
lw $t1, 0($v1)
la $v1, t44
sw $t1, 0($v1)
la $v1, t47
sw $t0, 0($v1)
la $v1, t48
lw $t0, 0($v1)
la $v1, t48
sw $t0, 0($v1)
la $v1, t47
lw $t0, 0($v1)
la $v1, t48
lw $t1, 0($v1)
la $v1, t49
lw $t2, 0($v1)
add $t2, $t0, $t1
la $v1, t49
sw $t2, 0($v1)
la $v1, t48
sw $t1, 0($v1)
la $v1, t47
sw $t0, 0($v1)
la $v1, t44
lw $t0, 0($v1)
la $v1, t49
lw $t1, 0($v1)
la $v1, t49
sw $t1, 0($v1)
la $v1, t44
sw $t0, 0($v1)
jr 20017-loot51
20017-ext51r-eval:
