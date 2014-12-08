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
la $v1, t52
lw $t0, 0($v1)
la $v1, t52
sw $t0, 0($v1)
la $v1, t53
l.s $f0, 0($v1)
la $v1, t53
s.s $f0, 0($v1)
la $v1, t54
lw $t0, 0($v1)
la $v1, t54
sw $t0, 0($v1)
la $v1, t55
l.s $f0, 0($v1)
la $v1, t55
s.s $f0, 0($v1)
la $v1, t56
lw $t0, 0($v1)
la $v1, t56
sw $t0, 0($v1)
la $v1, t57
l.s $f0, 0($v1)
la $v1, t57
s.s $f0, 0($v1)
la $v1, t58
lw $t0, 0($v1)
la $v1, t58
sw $t0, 0($v1)
la $v1, t10
lw $t0, 0($v1)
la $v1, t58
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
la $v1, t58
sw $t1, 0($v1)
la $v1, t10
sw $t0, 0($v1)
la $v1, t11
lw $t0, 0($v1)
la $v1, t52
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
la $v1, t52
sw $t1, 0($v1)
la $v1, t11
sw $t0, 0($v1)
la $v1, t13
lw $t0, 0($v1)
la $v1, t13
sw $t0, 0($v1)
la $v1, t14
lw $t0, 0($v1)
la $v1, t52
lw $t1, 0($v1)
la $v1, t52
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
la $v1, t17
l.s $f0, 0($v1)
la $v1, t17
s.s $f0, 0($v1)
la $v1, t16
lw $t0, 0($v1)
la $v1, t17
l.s $f0, 0($v1)
add $v1, $fp, $zero
add $fp, $sp, $zero
addi $sp, $sp, -1
s.s $f0, 0($sp)
addi $sp, $sp, -1
sw $ra, 0($sp)
addi $sp, $sp, -1
sw $v1, 0($sp)
jr $t0
sw $v0, func2($zero)
add $t0, $v0, $zero
la $v1, t17
s.s $f0, 0($v1)
la $v1, t16
sw $t0, 0($v1)
la $v1, t19
lw $t0, 0($v1)
la $v1, t19
sw $t0, 0($v1)
la $v1, t18
lw $t0, 0($v1)
la $v1, t19
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
la $v1, t19
sw $t1, 0($v1)
la $v1, t18
sw $t0, 0($v1)
la $v1, t20
lw $t0, 0($v1)
la $v1, t53
l.s $f0, 0($v1)
add $v1, $fp, $zero
add $fp, $sp, $zero
addi $sp, $sp, -1
s.s $f0, 0($sp)
addi $sp, $sp, -1
sw $ra, 0($sp)
addi $sp, $sp, -1
sw $v1, 0($sp)
jr $t0
sw $v0, func2($zero)
add $t0, $v0, $zero
la $v1, t53
s.s $f0, 0($v1)
la $v1, t20
sw $t0, 0($v1)
la $v1, t21
lw $t0, 0($v1)
la $v1, t52
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
la $v1, t52
sw $t1, 0($v1)
la $v1, t21
sw $t0, 0($v1)
la $v1, t23
l.s $f0, 0($v1)
la $v1, t23
s.s $f0, 0($v1)
la $v1, t24
l.s $f0, 0($v1)
la $v1, t53
l.s $f1, 0($v1)
la $v1, t53
s.s $f1, 0($v1)
la $v1, t24
s.s $f0, 0($v1)
la $v1, t23
l.s $f0, 0($v1)
la $v1, t24
l.s $f1, 0($v1)
la $v1, t25
lw $t0, 0($v1)
mtc1 $t0, $f31
cvt.s.w $f31, $f31
add.s $f0, $f1, $f31
la $v1, t25
sw $t0, 0($v1)
la $v1, t24
s.s $f1, 0($v1)
la $v1, t23
s.s $f0, 0($v1)
la $v1, t22
lw $t0, 0($v1)
la $v1, t25
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
la $v1, t25
sw $t1, 0($v1)
la $v1, t22
sw $t0, 0($v1)
la $v1, t27
lw $t0, 0($v1)
la $v1, t27
sw $t0, 0($v1)
la $v1, t28
l.s $f0, 0($v1)
la $v1, t53
l.s $f1, 0($v1)
la $v1, t53
s.s $f1, 0($v1)
la $v1, t28
s.s $f0, 0($v1)
la $v1, t27
lw $t0, 0($v1)
la $v1, t28
l.s $f0, 0($v1)
la $v1, t29
lw $t1, 0($v1)
mtc1 $t1, $f29
cvt.s.w $f29, $f29
add.s $f30, $f0, $f29
la $v1, t29
sw $t1, 0($v1)
la $v1, t28
s.s $f0, 0($v1)
la $v1, t27
sw $t0, 0($v1)
la $v1, t26
lw $t0, 0($v1)
la $v1, t29
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
la $v1, t29
sw $t1, 0($v1)
la $v1, t26
sw $t0, 0($v1)
la $v1, t31
l.s $f0, 0($v1)
la $v1, t31
s.s $f0, 0($v1)
la $v1, t32
lw $t0, 0($v1)
la $v1, t52
lw $t1, 0($v1)
la $v1, t52
sw $t1, 0($v1)
la $v1, t32
sw $t0, 0($v1)
la $v1, t31
l.s $f0, 0($v1)
la $v1, t32
lw $t0, 0($v1)
la $v1, t33
lw $t1, 0($v1)
mtc1 $t1, $f27
cvt.s.w $f27, $f27
add.s $f0, $f28, $f27
la $v1, t33
sw $t1, 0($v1)
la $v1, t32
sw $t0, 0($v1)
la $v1, t31
s.s $f0, 0($v1)
la $v1, t30
lw $t0, 0($v1)
la $v1, t33
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
la $v1, t33
sw $t1, 0($v1)
la $v1, t30
sw $t0, 0($v1)
la $v1, t35
lw $t0, 0($v1)
la $v1, t35
sw $t0, 0($v1)
la $v1, t36
lw $t0, 0($v1)
la $v1, t52
lw $t1, 0($v1)
la $v1, t52
sw $t1, 0($v1)
la $v1, t36
sw $t0, 0($v1)
la $v1, t35
lw $t0, 0($v1)
la $v1, t36
lw $t1, 0($v1)
la $v1, t37
lw $t2, 0($v1)
add $t2, $t0, $t1
la $v1, t37
sw $t2, 0($v1)
la $v1, t36
sw $t1, 0($v1)
la $v1, t35
sw $t0, 0($v1)
la $v1, t34
lw $t0, 0($v1)
la $v1, t37
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
la $v1, t37
sw $t1, 0($v1)
la $v1, t34
sw $t0, 0($v1)
la $v1, t38
lw $t0, 0($v1)
la $v1, t54
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
la $v1, t54
sw $t1, 0($v1)
la $v1, t38
sw $t0, 0($v1)
la $v1, t39
lw $t0, 0($v1)
la $v1, t56
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
la $v1, t56
sw $t1, 0($v1)
la $v1, t39
sw $t0, 0($v1)
la $v1, t40
lw $t0, 0($v1)
la $v1, t55
l.s $f0, 0($v1)
add $v1, $fp, $zero
add $fp, $sp, $zero
addi $sp, $sp, -1
s.s $f0, 0($sp)
addi $sp, $sp, -1
sw $ra, 0($sp)
addi $sp, $sp, -1
sw $v1, 0($sp)
jr $t0
sw $v0, func4($zero)
add $t0, $v0, $zero
la $v1, t55
s.s $f0, 0($v1)
la $v1, t40
sw $t0, 0($v1)
la $v1, t41
lw $t0, 0($v1)
la $v1, t57
l.s $f0, 0($v1)
add $v1, $fp, $zero
add $fp, $sp, $zero
addi $sp, $sp, -1
s.s $f0, 0($sp)
addi $sp, $sp, -1
sw $ra, 0($sp)
addi $sp, $sp, -1
sw $v1, 0($sp)
jr $t0
sw $v0, func4($zero)
add $t0, $v0, $zero
la $v1, t57
s.s $f0, 0($v1)
la $v1, t41
sw $t0, 0($v1)
loop_04009:
la $v1, t42
lw $t0, 0($v1)
la $v1, t42
sw $t0, 0($v1)
la $v1, t43
lw $t0, 0($v1)
la $v1, t43
sw $t0, 0($v1)
la $v1, t42
lw $t0, 0($v1)
la $v1, t43
lw $t1, 0($v1)
bne $t0, $t1, expr_eval_04009
la $v1, t43
sw $t1, 0($v1)
la $v1, t42
sw $t0, 0($v1)
la $v1, t44
lw $t0, 0($v1)
la $v1, t54
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
la $v1, t54
sw $t1, 0($v1)
la $v1, t44
sw $t0, 0($v1)
la $v1, t45
lw $t0, 0($v1)
la $v1, t55
l.s $f0, 0($v1)
add $v1, $fp, $zero
add $fp, $sp, $zero
addi $sp, $sp, -1
s.s $f0, 0($sp)
addi $sp, $sp, -1
sw $ra, 0($sp)
addi $sp, $sp, -1
sw $v1, 0($sp)
jr $t0
sw $v0, func4($zero)
add $t0, $v0, $zero
la $v1, t55
s.s $f0, 0($v1)
la $v1, t45
sw $t0, 0($v1)
jr expr_eval_04009
jr loop_04009
expr_eval_04009:
la $v1, t46
lw $t0, 0($v1)
la $v1, t46
sw $t0, 0($v1)
la $v1, t47
lw $t0, 0($v1)
la $v1, t47
sw $t0, 0($v1)
loop_79882:
la $v1, t46
lw $t0, 0($v1)
la $v1, t47
lw $t1, 0($v1)
bne $t0, $t1, expr_eval_79882
la $v1, t47
sw $t1, 0($v1)
la $v1, t46
sw $t0, 0($v1)
la $v1, t48
lw $t0, 0($v1)
la $v1, t48
sw $t0, 0($v1)
la $v1, t54
lw $t0, 0($v1)
la $v1, t48
lw $t1, 0($v1)
la $v1, t48
sw $t1, 0($v1)
la $v1, t54
sw $t0, 0($v1)
jr expr_eval_79882
la $v1, t49
lw $t0, 0($v1)
la $v1, t46
lw $t1, 0($v1)
la $v1, t46
sw $t1, 0($v1)
la $v1, t49
sw $t0, 0($v1)
la $v1, t50
lw $t0, 0($v1)
la $v1, t50
sw $t0, 0($v1)
la $v1, t49
lw $t0, 0($v1)
la $v1, t50
lw $t1, 0($v1)
la $v1, t51
lw $t2, 0($v1)
add $t2, $t0, $t1
la $v1, t51
sw $t2, 0($v1)
la $v1, t50
sw $t1, 0($v1)
la $v1, t49
sw $t0, 0($v1)
la $v1, t46
lw $t0, 0($v1)
la $v1, t51
lw $t1, 0($v1)
la $v1, t51
sw $t1, 0($v1)
la $v1, t46
sw $t0, 0($v1)
jr loop_79882
expr_eval_79882:
