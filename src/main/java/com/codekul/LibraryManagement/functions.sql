CREATE OR REPLACE FUNCTION public.fn_return_book(
	borrowedId bigint)
    RETURNS void
    LANGUAGE 'plpgsql'
    COST 100
    VOLATILE PARALLEL UNSAFE
AS $BODY$

DECLARE bookId bigint;
  finePerDay numeric = 10.00;
  finePeriod int =5;
  noOfDays integer;
BEGIN

	select book_id into bookId from books_borrowed where id = borrowedId;

 	update books set is_available =true where id = bookId;

	update books_borrowed set return_date = now() where id = borrowedId;

	select (now()::date-(select borrowed_date::date from books_borrowed where id =borrowedId)) into noOfDays;

	if(noOfDays>finePeriod) then
		insert into fine(borrowed_date,return_date,book_id,student_id,amount)
		select borrowed_date,return_date,book_id,student_id,((noOfDays-finePeriod)*finePerDay)
		from books_borrowed where id = borrowedId;
	end if;

END;

$BODY$;



CREATE OR REPLACE FUNCTION public.fn_check_book_is_availble_flag(
	bookid bigint)
    RETURNS TABLE(isavailable boolean)
    LANGUAGE 'plpgsql'
    COST 100
    VOLATILE PARALLEL UNSAFE
    ROWS 1000

AS $BODY$

BEGIN
 	return query select is_available from books where id = bookId;
END;

$BODY$;


CREATE OR REPLACE FUNCTION public.fn_getuserinfo(
	usrnm text,
	pwd text)
    RETURNS TABLE(username text, role text)
    LANGUAGE 'plpgsql'
    COST 100
    VOLATILE PARALLEL UNSAFE
    ROWS 1000

AS $BODY$

BEGIN
 	return query SELECT u.user_name::text,u.role::text from users u where u.user_name = usrNm;
END;

$BODY$;


CREATE OR REPLACE FUNCTION public.fn_update_book_is_availble_flag(
	bookid bigint)
    RETURNS void
    LANGUAGE 'plpgsql'
    COST 100
    VOLATILE PARALLEL UNSAFE
AS $BODY$

BEGIN
 	update books set is_available =false where id = bookId;
END;

$BODY$;