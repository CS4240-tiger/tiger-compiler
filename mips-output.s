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
t52: .word 5
t53: .float 5.0
t54: .word 5
t55: .float 5.0
t56: .word 5
t57: .float 5.0
t58: .word 5
t10: .word 0
t11: .word 0
t13: .word 5
t14: .word 5
t15: .word 0
t12: .word 0
t17: .float 5.0
t16: .word 0
t19: .word 5
t18: .word 0
t20: .word 0
t21: .word 0
t23: .float 5.0
t24: .float 5.0
t25: .word 0
t22: .word 0
t27: .word 5
t28: .float 5.0
t29: .word 0
t26: .word 0
t31: .float 5.0
t32: .word 5
t33: .word 0
t30: .word 0
t35: .word 5
t36: .word 5
t37: .word 0
t34: .word 0
t38: .word 0
t39: .word 0
t40: .word 0
t41: .word 0
t42: .word 1
t43: .word 2
t44: .word 0
t45: .word 0
t46: .word 1
t47: .word 9000
t48: .word 9000
t49: .word 1
t50: .word 1
t51: .word 0
.text
func1:
la $at, t1
lw $t0, 0($at)
la $at, t0
lw $t1, 0($at)
la $at, t1
sw $t0, 0($at)
la $at, t0
sw $t1, 0($at)
addi $sp, $sp, 1
lw $fp, 0($sp)
addi $sp, $sp, 1
lw $ra, 0($sp)
add $sp, $fp, $zero
jr $ra
la $at, t3
lw $t0, 0($at)
la $at, t2
lw $t1, 0($at)
la $at, t3
sw $t0, 0($at)
la $at, t2
sw $t1, 0($at)
addi $sp, $sp, 1
lw $fp, 0($sp)
addi $sp, $sp, 1
lw $ra, 0($sp)
add $sp, $fp, $zero
jr $ra
func2:
la $at, t4
lw $t0, 0($at)
la $at, t5
lw $t1, 0($at)
la $at, t4
sw $t0, 0($at)
la $at, t5
sw $t1, 0($at)
addi $sp, $sp, 1
lw $fp, 0($sp)
addi $sp, $sp, 1
lw $ra, 0($sp)
add $sp, $fp, $zero
jr $ra
func3:
la $at, t6
lw $t0, 0($at)
la $at, t7
lw $t1, 0($at)
la $at, t6
sw $t0, 0($at)
la $at, t7
sw $t1, 0($at)
addi $sp, $sp, 1
lw $fp, 0($sp)
addi $sp, $sp, 1
lw $ra, 0($sp)
add $sp, $fp, $zero
jr $ra
func4:
la $at, t8
lw $f0, 0($at)
la $at, t9
lw $f1, 0($at)
la $at, t8
sw $f0, 0($at)
la $at, t9
sw $f1, 0($at)
addi $sp, $sp, 1
lw $fp, 0($sp)
addi $sp, $sp, 1
lw $ra, 0($sp)
add $sp, $fp, $zero
jr $ra
main:
la $at, t35
lw $s1, 0($at)
la $at, t36
lw $s3, 0($at)
la $at, t11
lw $s4, 0($at)
la $at, t30
lw $s6, 0($at)
la $at, t12
lw $s5, 0($at)
la $at, t13
lw $s7, 0($at)
la $at, t22
lw $t2, 0($at)
la $at, t14
lw $t0, 0($at)
la $at, t15
lw $t1, 0($at)
la $at, t28
lw $t3, 0($at)
la $at, t26
lw $t4, 0($at)
la $at, t27
lw $t5, 0($at)
la $at, t37
lw $s2, 0($at)
la $at, t19
lw $s0, 0($at)
la $at, t58
lw $t6, 0($at)
la $at, t56
lw $t7, 0($at)
la $at, t54
lw $t8, 0($at)
la $at, t52
lw $t9, 0($at)
la $at, t33
lw $f0, 0($at)
la $at, t24
lw $f1, 0($at)
la $at, t25
lw $f2, 0($at)
la $at, t31
lw $f4, 0($at)
la $at, t40
lw $f3, 0($at)
la $at, t23
lw $f6, 0($at)
la $at, t41
lw $f5, 0($at)
la $at, t28
lw $f7, 0($at)
la $at, t57
lw $f10, 0($at)
la $at, t29
lw $f8, 0($at)
la $at, t17
lw $f9, 0($at)
la $at, t55
lw $f11, 0($at)
la $at, t53
lw $f12, 0($at)
la $at, t11
sw $s4, 0($at)
la $at, t10
lw $s4, 0($at)
add $v1, $fp, $zero
add $fp, $sp, $zero
addi $sp, $sp, -1
sw $t6, 0($sp)
addi $sp, $sp, -1
sw $ra, 0($sp)
addi $sp, $sp, -1
sw $v1, 0($sp)
jr $s4
sw $v0, func1($zero)
add $s4, $v0, $zero
la $at, t10
sw $s4, 0($at)
la $at, t11
lw $s4, 0($at)
add $v1, $fp, $zero
add $fp, $sp, $zero
addi $sp, $sp, -1
sw $t9, 0($sp)
addi $sp, $sp, -1
sw $ra, 0($sp)
addi $sp, $sp, -1
sw $v1, 0($sp)
jr $s4
sw $v0, func1($zero)
add $s4, $v0, $zero
add $t1, $s7, $t0
add $v1, $fp, $zero
add $fp, $sp, $zero
addi $sp, $sp, -1
sw $t1, 0($sp)
addi $sp, $sp, -1
sw $ra, 0($sp)
addi $sp, $sp, -1
sw $v1, 0($sp)
jr $s5
sw $v0, func1($zero)
add $s5, $v0, $zero
la $at, t11
sw $s4, 0($at)
la $at, t16
lw $s4, 0($at)
add $v1, $fp, $zero
add $fp, $sp, $zero
addi $sp, $sp, -1
s.s $f9, 0($sp)
addi $sp, $sp, -1
sw $ra, 0($sp)
addi $sp, $sp, -1
sw $v1, 0($sp)
jr $s4
sw $v0, func2($zero)
add $s4, $v0, $zero
la $at, t30
sw $s6, 0($at)
la $at, t18
lw $s6, 0($at)
add $v1, $fp, $zero
add $fp, $sp, $zero
addi $sp, $sp, -1
sw $s0, 0($sp)
addi $sp, $sp, -1
sw $ra, 0($sp)
addi $sp, $sp, -1
sw $v1, 0($sp)
jr $s6
sw $v0, func2($zero)
add $s6, $v0, $zero
la $at, t12
sw $s5, 0($at)
la $at, t20
lw $s5, 0($at)
add $v1, $fp, $zero
add $fp, $sp, $zero
addi $sp, $sp, -1
s.s $f12, 0($sp)
addi $sp, $sp, -1
sw $ra, 0($sp)
addi $sp, $sp, -1
sw $v1, 0($sp)
jr $s5
sw $v0, func2($zero)
add $s5, $v0, $zero
la $at, t20
sw $s5, 0($at)
la $at, t21
lw $s5, 0($at)
add $v1, $fp, $zero
add $fp, $sp, $zero
addi $sp, $sp, -1
sw $t9, 0($sp)
addi $sp, $sp, -1
sw $ra, 0($sp)
addi $sp, $sp, -1
sw $v1, 0($sp)
jr $s5
sw $v0, func2($zero)
add $s5, $v0, $zero
add.s $f6, $f1, $f2
add $v1, $fp, $zero
add $fp, $sp, $zero
addi $sp, $sp, -1
s.s $f2, 0($sp)
addi $sp, $sp, -1
sw $ra, 0($sp)
addi $sp, $sp, -1
sw $v1, 0($sp)
jr $t2
sw $v0, func2($zero)
add $t2, $v0, $zero
add.s $t5, $t3, $f8
add $v1, $fp, $zero
add $fp, $sp, $zero
addi $sp, $sp, -1
s.s $f8, 0($sp)
addi $sp, $sp, -1
sw $ra, 0($sp)
addi $sp, $sp, -1
sw $v1, 0($sp)
jr $t4
sw $v0, func2($zero)
add $t4, $v0, $zero
la $at, t21
sw $s5, 0($at)
la $at, t32
lw $s5, 0($at)
la $at, t40
sw $f3, 0($at)
la $at, t32
lw $f3, 0($at)
add.s $f4, $f3, $f0
la $at, t22
sw $t2, 0($at)
la $at, t30
lw $t2, 0($at)
add $v1, $fp, $zero
add $fp, $sp, $zero
addi $sp, $sp, -1
s.s $f0, 0($sp)
addi $sp, $sp, -1
sw $ra, 0($sp)
addi $sp, $sp, -1
sw $v1, 0($sp)
jr $t2
sw $v0, func2($zero)
add $t2, $v0, $zero
add $s2, $s1, $s3
la $at, t30
sw $t2, 0($at)
la $at, t34
lw $t2, 0($at)
add $v1, $fp, $zero
add $fp, $sp, $zero
addi $sp, $sp, -1
sw $s2, 0($sp)
addi $sp, $sp, -1
sw $ra, 0($sp)
addi $sp, $sp, -1
sw $v1, 0($sp)
jr $t2
sw $v0, func2($zero)
add $t2, $v0, $zero
la $at, t34
sw $t2, 0($at)
la $at, t38
lw $t2, 0($at)
add $v1, $fp, $zero
add $fp, $sp, $zero
addi $sp, $sp, -1
sw $t8, 0($sp)
addi $sp, $sp, -1
sw $ra, 0($sp)
addi $sp, $sp, -1
sw $v1, 0($sp)
jr $t2
sw $v0, func3($zero)
add $t2, $v0, $zero
la $at, t32
sw $s5, 0($at)
la $at, t39
lw $s5, 0($at)
add $v1, $fp, $zero
add $fp, $sp, $zero
addi $sp, $sp, -1
sw $t7, 0($sp)
addi $sp, $sp, -1
sw $ra, 0($sp)
addi $sp, $sp, -1
sw $v1, 0($sp)
jr $s5
sw $v0, func3($zero)
add $s5, $v0, $zero
la $at, t41
sw $f5, 0($at)
la $at, t40
lw $f5, 0($at)
add $v1, $fp, $zero
add $fp, $sp, $zero
addi $sp, $sp, -1
s.s $f11, 0($sp)
addi $sp, $sp, -1
sw $ra, 0($sp)
addi $sp, $sp, -1
sw $v1, 0($sp)
jr $f5
sw $v0, func4($zero)
add $f5, $v0, $zero
la $at, t35
sw $s1, 0($at)
la $at, t36
sw $s3, 0($at)
la $at, t13
sw $s7, 0($at)
la $at, t14
sw $t0, 0($at)
la $at, t15
sw $t1, 0($at)
la $at, t28
sw $t3, 0($at)
la $at, t16
sw $s4, 0($at)
la $at, t26
sw $t4, 0($at)
la $at, t18
sw $s6, 0($at)
la $at, t27
sw $t5, 0($at)
la $at, t37
sw $s2, 0($at)
la $at, t19
sw $s0, 0($at)
la $at, t38
sw $t2, 0($at)
la $at, t39
sw $s5, 0($at)
la $at, t58
sw $t6, 0($at)
la $at, t56
sw $t7, 0($at)
la $at, t54
sw $t8, 0($at)
la $at, t52
sw $t9, 0($at)
la $at, t33
sw $f0, 0($at)
la $at, t24
sw $f1, 0($at)
la $at, t25
sw $f2, 0($at)
la $at, t40
sw $f5, 0($at)
la $at, t31
sw $f4, 0($at)
la $at, t32
sw $f3, 0($at)
la $at, t23
sw $f6, 0($at)
la $at, t28
sw $f7, 0($at)
la $at, t29
sw $f8, 0($at)
la $at, t17
sw $f9, 0($at)
la $at, t57
sw $f10, 0($at)
la $at, t55
sw $f11, 0($at)
la $at, t53
sw $f12, 0($at)
la $at, t40
sw $f5, 0($at)
la $at, t41
lw $f5, 0($at)
add $v1, $fp, $zero
add $fp, $sp, $zero
addi $sp, $sp, -1
s.s $f10, 0($sp)
addi $sp, $sp, -1
sw $ra, 0($sp)
addi $sp, $sp, -1
sw $v1, 0($sp)
jr $f5
sw $v0, func4($zero)
add $f5, $v0, $zero
loop_68263:
la $at, t42
lw $t0, 0($at)
la $at, t43
lw $t1, 0($at)
la $at, t42
sw $t0, 0($at)
la $at, t43
sw $t1, 0($at)
bne $t0, $t1, expr_eval_68263
la $at, t44
lw $t0, 0($at)
la $at, t54
lw $t1, 0($at)
la $at, t45
lw $f0, 0($at)
la $at, t55
lw $f1, 0($at)
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
add $v1, $fp, $zero
add $fp, $sp, $zero
addi $sp, $sp, -1
s.s $f1, 0($sp)
addi $sp, $sp, -1
sw $ra, 0($sp)
addi $sp, $sp, -1
sw $v1, 0($sp)
jr $f0
sw $v0, func4($zero)
add $f0, $v0, $zero
la $at, t44
sw $t0, 0($at)
la $at, t54
sw $t1, 0($at)
la $at, t45
sw $f0, 0($at)
la $at, t55
sw $f1, 0($at)
jr expr_eval_68263
expr_eval_68263:
la $at, t46
lw $t0, 0($at)
la $at, t47
lw $t1, 0($at)
la $at, t46
sw $t0, 0($at)
la $at, t47
sw $t1, 0($at)
loop_17216:
la $at, t46
lw $t0, 0($at)
la $at, t47
lw $t1, 0($at)
la $at, t46
sw $t0, 0($at)
la $at, t47
sw $t1, 0($at)
bne $t0, $t1, expr_eval_17216
la $at, t54
lw $t0, 0($at)
la $at, t48
lw $t1, 0($at)
la $at, t54
sw $t0, 0($at)
la $at, t48
sw $t1, 0($at)
jr expr_eval_17216
la $at, t46
lw $t0, 0($at)
la $at, t50
lw $t1, 0($at)
la $at, t49
lw $t3, 0($at)
la $at, t51
lw $t2, 0($at)
add $t2, $t3, $t1
la $at, t46
sw $t0, 0($at)
la $at, t50
sw $t1, 0($at)
la $at, t49
sw $t3, 0($at)
la $at, t51
sw $t2, 0($at)
jr loop_17216
expr_eval_17216:
