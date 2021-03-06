PGDMP         4                z         
   tweeter_db    14.1    14.1     ?           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            ?           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            ?           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            ?           1262    16525 
   tweeter_db    DATABASE     g   CREATE DATABASE tweeter_db WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'English_Sweden.1252';
    DROP DATABASE tweeter_db;
                postgres    false            ?            1259    16546    tweets    TABLE       CREATE TABLE public.tweets (
    twt_id integer NOT NULL,
    usr_id integer NOT NULL,
    created_twt timestamp without time zone DEFAULT now(),
    updated_twt timestamp without time zone DEFAULT now(),
    likes_twt integer DEFAULT 0,
    content_twt character varying(200)
);
    DROP TABLE public.tweets;
       public         heap    postgres    false            ?            1259    16545    tweets_twt_id_seq    SEQUENCE     ?   ALTER TABLE public.tweets ALTER COLUMN twt_id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.tweets_twt_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    210            ?            1259    16561    tweets_ver2    TABLE     ?   CREATE TABLE public.tweets_ver2 (
    twt_id integer NOT NULL,
    created_twt timestamp without time zone DEFAULT now(),
    content_twt character(200)
);
    DROP TABLE public.tweets_ver2;
       public         heap    postgres    false            ?            1259    16560    tweets_ver2_twt_id_seq    SEQUENCE     ?   ALTER TABLE public.tweets_ver2 ALTER COLUMN twt_id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.tweets_ver2_twt_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    212            ?          0    16546    tweets 
   TABLE DATA           b   COPY public.tweets (twt_id, usr_id, created_twt, updated_twt, likes_twt, content_twt) FROM stdin;
    public          postgres    false    210   ?       ?          0    16561    tweets_ver2 
   TABLE DATA           G   COPY public.tweets_ver2 (twt_id, created_twt, content_twt) FROM stdin;
    public          postgres    false    212   Y       ?           0    0    tweets_twt_id_seq    SEQUENCE SET     ?   SELECT pg_catalog.setval('public.tweets_twt_id_seq', 1, true);
          public          postgres    false    209            ?           0    0    tweets_ver2_twt_id_seq    SEQUENCE SET     E   SELECT pg_catalog.setval('public.tweets_ver2_twt_id_seq', 24, true);
          public          postgres    false    211            f           2606    16553    tweets tweets_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.tweets
    ADD CONSTRAINT tweets_pkey PRIMARY KEY (twt_id);
 <   ALTER TABLE ONLY public.tweets DROP CONSTRAINT tweets_pkey;
       public            postgres    false    210            h           2606    16566    tweets_ver2 tweets_ver2_pkey 
   CONSTRAINT     ^   ALTER TABLE ONLY public.tweets_ver2
    ADD CONSTRAINT tweets_ver2_pkey PRIMARY KEY (twt_id);
 F   ALTER TABLE ONLY public.tweets_ver2 DROP CONSTRAINT tweets_ver2_pkey;
       public            postgres    false    212            ?   d   x?}ɻ?0E?:??-@??6???1?(@?F?O&@:??ƛ?c,|?!4??R?]݆?˛q??񈂰??L?P??n|3?t*??~
?
?g]?????? ?      ?      x?ݖKo?0???Wx??5?m?GQ.i??c.?K????????m#?ڴ?fw????o???????\??bv?˽^6?z??Zo??j{ݯ??e????狛/?s??CQ*iI?;~c???kS/??U?OK?? (l0?#y?쫮<????[U?U???????8????-??D?e?l??|?=;??M?'?c?????K?Zb???"??XJjI???#? ?Ýr?qA???,??dNʧ?\ q ?h?????M???????X
L?????yY??,e??4Z:?k6V4?O"?G ??E#?3???g???D??AN?G?+al
???}t?s?7?/?e???F?M7.???O)?? 1e??שk???0L5cP???4?T3.?܀8??+?!?K??a?ZKY??\???m?w????*©&??6;??멈???&??w˳Uĩ%?vo<?f/??j?ݝz??!?DSx?Q????z????ч'?z??
?`?R? ?k??     