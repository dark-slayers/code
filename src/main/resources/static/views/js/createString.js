const t=`@Column(name = "expect_${f}_start_date")
private LocalDate expectBomStartDate;
@Column(name = "expect_bom_end_date")
private LocalDate expectBomEndDate;
@Column(name = "bom_start_date")
private LocalDate bomStartDate;
@Column(name = "bom_end_date")
private LocalDate bomEndDate;`;