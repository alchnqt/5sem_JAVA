$(document).ready(function () {
    const action = {
        beforeSend: {

            spinner: function () {
                if ($(".loader").length !== 0) {
                    $(".loader").show();
                }
            }

        },

        complete: {

            spinner: function () {
                if ($(".loader").length !== 0) {
                    $(".loader").hide();
                }
            }

        },

        success: {
            signIn: function (response) {
                if ($('.result').length !== 0) {
                    if (response.success) {

                        if ($('.result').length !== 0) {
                            $('.result').text(response.message)
                            $('.result').toggleClass('text-success')
                        }
                    }
                    else {
                        if ($('.result').length !== 0) {
                            $('.result').text(response.message)
                            $('.result').toggleClass('text-danger')
                        }
                    }
                }
            },

            signUp: function (response) {

                if ($('.result').length !== 0) {
                    if (response.success) {
                        $('.result').text(response.message);
                        $('.result').toggleClass('text-success')
                        $('.ajaxForm').toggleClass('collapse');
                    }
                    else {
                        $('.result').text(response.message)
                        $('.result').toggleClass('text-danger')
                    }
                }
            },

            setPassword: function (response) {
                if (response.result) {
                    window.location.href = response.url;
                }
            },

            addSong: function (response) {
                if (response.result) {
                    window.location.href = response.url;
                }
            }
        }
    }

    $('.ajaxForm').on('submit', function (e) {
        e.preventDefault();
        let ajaxObject = {};
        const $form = $(this);
        $form.validate();
        if ($form.valid()) {
            ajaxObject.method = $form.attr('method').toUpperCase();
            ajaxObject.url = $form.attr('action');
            ajaxObject.data = $form.serialize();
            ajaxObject.beforeSend = action.beforeSend.spinner;
            ajaxObject.complete = action.complete.spinner;
            ajaxObject.success = function (response) {
                action.success[$form.attr('postAction')](response);
            }
            $.ajax(ajaxObject);
        }
    })
});